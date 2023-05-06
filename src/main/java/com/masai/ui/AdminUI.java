package com.masai.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


import com.masai.entities.Crime;
import com.masai.entities.PoliceStation;
import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.CrimeService;
import com.masai.service.CrimeServiceImpl;
import com.masai.service.PoliceStationService;
import com.masai.service.PoliceStationServiceImpl;

public class AdminUI {
static void addCrime(Scanner sc) {
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
	
	PoliceStationService pss = new PoliceStationServiceImpl(); 
	List<PoliceStation> psList=null;
	try {
		psList = pss.getAllPoliceStation();
	} catch (RecordNotFoundException e1) {
		System.out.println(e1.getMessage());
		return;
	}
	psList.forEach(el->System.out.println(el.getId()+". "+el.getName()));
	
	System.out.print("Enter Choose Police station id");
	int psid = sc.nextInt();
	PoliceStation ps = null;
	for(PoliceStation li:psList) {
		if(li.getId()==psid) {
			ps=li;
		}
	}
	if(ps==null) {
		System.out.println("Invalid Police Station Id");
		return;
	}
	
	System.out.print("Enter Police Station Area");
	String psAreaName = sc.next();
	PsArea psa = new PsArea(psAreaName,ps,null);
	
	System.out.print("Enter Crime Date (DD-MM-YYYY)");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Date date =Date.valueOf(LocalDate.parse(sc.next(), formatter));
	System.out.print("Enter Name of Victom");
	String victom = sc.next();
	
	Crime crime = new Crime(crimeType, description, date, victom, null, psa);
	
	CrimeService cs = new CrimeServiceImpl();
	try {
		cs.addCrime(crime);
		System.out.println("Crime Registered Successful");
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
}

public static void addPoliceStation(Scanner sc) {
	System.out.println("Enter Name of Police station");
	String name = sc.next();
	System.out.println("Enter Police station Address");
	sc.nextLine();
	String address = sc.nextLine();
	System.out.println("Enter 6 digit Pin Code");
	int pincode=sc.nextInt();
	PoliceStation ps = new PoliceStation(name, address,pincode, null);
	PoliceStationService pss = new PoliceStationServiceImpl();
	try {
		pss.addPoliceStation(ps);
		System.out.println("Police Station Added Successful");
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
}

public static void updateCrimeDetails(Scanner sc) {
	int choice=0;
	do {
		System.out.println("1. Update Crime Type");
		System.out.println("2. Update Crime Description");
		System.out.println("3. Update Crime PoliceStation Area");
		System.out.println("4. Update Crime Date");
		System.out.println("5. Update Crime Victim");
		System.out.println("0. Back");
		System.out.print("Selection Choice");
		choice = sc.nextInt();
		switch(choice) {
		case 1: updateCrimeType(sc);
			break;
		case 2:updateCrimeDescription(sc);
			break;
		case 3:updateCrimePsArea(sc);
			break;
		case 4:updateCrimeDate(sc);
			break;
		case 5:updateCrimeVictim(sc);
			break;
		case 0:
			break;
		default:System.out.println("Invalid Selection");
		}
		
	}while(choice!=0);
	
}

private static void updateCrimeVictim(Scanner sc) {
	System.out.println("Enter Crime Id");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter Victim");
	String victim = sc.nextLine();
	
    CrimeService cs = new CrimeServiceImpl();
    try {
		cs.updateCrimeVictim(id, victim);
		System.out.println("Updated successful");
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

private static void updateCrimeDate(Scanner sc) {
	System.out.println("Enter Crime Id");
    int id = sc.nextInt();
    System.out.print("Enter Crime Date (DD-MM-YYYY)");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Date date =Date.valueOf(LocalDate.parse(sc.next(), formatter));
	
    CrimeService cs = new CrimeServiceImpl();
    try {
		cs.updateCrimeDate(id, date);
		System.out.println("Updated successful");
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

private static void updateCrimePsArea(Scanner sc) {
	System.out.println("Enter Crime Id");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter new PS Area");
	String psarea = sc.nextLine();
	
    CrimeService cs = new CrimeServiceImpl();
    try {
		cs.updateCrimePsArea(id, psarea);
		System.out.println("Updated successful");
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

private static void updateCrimeDescription(Scanner sc) {
	System.out.println("Enter Crime Id");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter Desription");
	String description = sc.nextLine();
	
    CrimeService cs = new CrimeServiceImpl();
    try {
		cs.updateCrimeDescription(id, description);
		System.out.println("Updated successful");
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

private static void updateCrimeType(Scanner sc) {
	System.out.println("Enter Crime Id");
     int id = sc.nextInt();
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
     CrimeService cs = new CrimeServiceImpl();
     try {
		cs.updateCrimeType(id, crimeType);
		System.out.println("Updated successful");
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}
}
