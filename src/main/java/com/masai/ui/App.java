package com.masai.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.masai.dao.EMUtils;
import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.CrimeService;
import com.masai.service.CrimeServiceImpl;
import com.masai.service.CriminalService;
import com.masai.service.CriminalServiceImpl;
import com.masai.service.PsAreaService;
import com.masai.service.PsAreaServiceImpl;

public class App 
{
	static void displayAdminMenu() {
		System.out.println("1. Add Crime");
		System.out.println("2. Add Police Station");
		System.out.println("3. Update Crime Details");
		System.out.println("4. Add Criminal");
		System.out.println("5. Update Criminal Details");
		System.out.println("6. Assign criminals to crime");
		System.out.println("7. Remove criminal From Crime");
		System.out.println("8. Delete Crime By id");
		System.out.println("9. Delete Criminal By id");
		System.out.println("0. Logout");
	}
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				AdminUI.addCrime(sc);
    				break;
    			case 2:
    				AdminUI.addPoliceStation(sc);
    				break;
    			case 3:
    				AdminUI.updateCrimeDetails(sc);
    				break;
    			case 4:
    				AdminUI.addCriminal(sc);
    				break;
    			case 5:
    				AdminUI.updateCriminalDetails(sc);
    				break;
    			case 6:
    				AdminUI.AssignCriminalToCrime(sc);
    				break;
    			case 7:
    				AdminUI.removeCriminalFromCrime(sc);
    				break;
    			case 8:
    				AdminUI.deleteCrimeById(sc);
    				break;
    			case 9:
    				AdminUI.deleteCriminalById(sc);
    				break;
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
    public static void main( String[] args ) 
    {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("Welcome to Crime Management System");
    		System.out.println("1. Admin Login");
    		System.out.println("2. total crime for each police station area for a date range.");
    		System.out.println("3. View total crime for each crime type for a date range");
    		System.out.println("4. Search for criminal by name");
    		System.out.println("5. Search for crime by description");
    		
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 2:
    				totalCrimeInEachPoliceStation(sc);
    				break;
    			case 3:
    				viewCrimesByType(sc);
    				break;
    			case 4:
    				SearchCriminalByName(sc);
    				break;
    			case 5:
    				SearchCrimeByDes(sc);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
    }

	private static void SearchCrimeByDes(Scanner sc) {
		System.out.println("Enter Crime Description");
		String des = sc.next();
		CrimeService cs = new CrimeServiceImpl();
		try {
			Crime crime = cs.getCrimeByDes(des);
			System.out.println("---------Crime--------");
			System.out.println("-Id-Description-");
			System.out.println(crime.getCrimeId()+". "+crime.getDescription());
			System.out.println("----------------------");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void SearchCriminalByName(Scanner sc) {
		System.out.println("Enter Criminal Name");
		String name = sc.next();
		CriminalService cs = new CriminalServiceImpl();
		try {
			Criminal criminal = cs.getCriminalByName(name);
			System.out.println("-----Criminal Details------");
			System.out.println("-Id--Name--ArrestPsArea-");
			System.out.println(criminal.getCriminalId()+". "+criminal.getName()+" "+criminal.getArrestedFromPsArea().getAreaName());
			System.out.println("---------------------------");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void viewCrimesByType(Scanner sc) {
		System.out.println("Enter start Date Range (YYYY-MM-DD)");
		Date startDate = Date.valueOf(LocalDate.parse(sc.next())) ;
		System.out.println("Enter end Date Range (YYYY-MM-DD)");
		Date endDate = Date.valueOf(LocalDate.parse(sc.next())) ;
		PsAreaService pas = new PsAreaServiceImpl();
		try {
			List<PsArea> listPsArea = pas.getPsAreaList();
			for(PsArea li: listPsArea) {
				if(li.getCrimes().size()!=0) {
					Set<Crime> list = li.getCrimes();
					
					for(Crime lis:list) {
						System.out.println("----------------------");
						System.out.println("Crime Type :"+lis.getType());
						System.out.println("-------Crimes--------");
						if(lis.getDate().before(endDate)&&lis.getDate().after(startDate)) {
							System.out.println(lis.getCrimeId()+". "+lis.getDescription());
						}
					}
					System.out.println("-------Crimes--------");
				}
				
			}
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void totalCrimeInEachPoliceStation(Scanner sc) {
		System.out.println("Enter start Date Range (YYYY-MM-DD)");
		Date startDate = Date.valueOf(LocalDate.parse(sc.next())) ;
		System.out.println("Enter end Date Range (YYYY-MM-DD)");
		Date endDate = Date.valueOf(LocalDate.parse(sc.next())) ;
		PsAreaService pas = new PsAreaServiceImpl();
		try {
			List<PsArea> listPsArea = pas.getPsAreaList();
			for(PsArea li: listPsArea) {
				if(li.getCrimes().size()!=0) {
					Set<Crime> list = li.getCrimes();
					System.out.println("----------------------");
					System.out.println("Police Station Area :"+li.getAreaName());
					System.out.println("-------Crimes--------");
					for(Crime lis:list) {
						if(lis.getDate().before(endDate)&&lis.getDate().after(startDate)) {
							System.out.println(lis.getCrimeId()+". "+lis.getDescription());
						}
					}
					System.out.println("-------Crimes--------");
				}
				
			}
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
    }

