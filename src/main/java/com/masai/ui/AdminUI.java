package com.masai.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.masai.entities.Crime;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.CrimeService;
import com.masai.service.CrimeServiceImpl;

public class AdminUI {
static void addCrime(Scanner sc) {
	//Robbery, Theft, Homicide
	System.out.print("Choose Crime Type 1. Robbery 2. Theft 3. Homicide");
	int crimeTypeint = sc.nextInt();
	String crimeType = "";
	if(crimeTypeint==1) {
		crimeType = "Robbery";
	}else if(crimeTypeint==2) {
		crimeType = "Theft";
	}else if(crimeTypeint==3) {
		crimeType = "Homicide";
	}else {
		System.out.println("Invalid selection");
		return;
	}
	System.out.print("Enter Description of Crime");
	String description = sc.next();
	System.out.print("Enter Police Station Area");
	String psArea = sc.next();
	System.out.print("Enter Crime Date (DD-MM-YYYY)");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Date date =Date.valueOf(LocalDate.parse(sc.next(), formatter));
	System.out.print("Enter Name of Victom");
	String victom = sc.next();
	
	Crime crime = new Crime(crimeType, description, psArea, date, victom, null);
	
	CrimeService cs = new CrimeServiceImpl();
	try {
		cs.addCrime(crime);
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
}
}
