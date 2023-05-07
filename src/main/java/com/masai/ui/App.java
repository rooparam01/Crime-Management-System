package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.EMUtils;
import com.masai.exception.SomethingWentWrongException;

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
    		System.out.println("1. Admin Login");
    		
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 2:
    				//CustomerUI.userLogin(sc);
    				break;
    			case 3:
    				//CustomerUI.customerRegistration(sc);
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
    }

