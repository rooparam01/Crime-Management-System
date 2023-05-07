package com.masai.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.entities.PoliceStation;
import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.CrimeService;
import com.masai.service.CrimeServiceImpl;
import com.masai.service.CriminalService;
import com.masai.service.CriminalServiceImpl;
import com.masai.service.PoliceStationService;
import com.masai.service.PoliceStationServiceImpl;
import com.masai.service.PsAreaService;
import com.masai.service.PsAreaServiceImpl;

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
	sc.nextLine();
	System.out.print("Enter Description of Crime");
	String description = sc.nextLine();
	
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
	sc.nextLine();
	System.out.print("Enter Police Station Area");
	String psAreaName = sc.nextLine();
	PsArea psa = new PsArea(psAreaName,ps,null);
	
	System.out.print("Enter Crime Date (DD-MM-YYYY)");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Date date =Date.valueOf(LocalDate.parse(sc.next(), formatter));
	sc.nextLine();
	System.out.print("Enter Name of Victom");
	String victom = sc.nextLine();
	
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

public static void addCriminal(Scanner sc) {
	System.out.println("Enter Criminal Id");
	int criminalid = sc.nextInt();
	sc.nextLine();
	System.out.print("Enter Criminal Name");
	String name=sc.nextLine();
	System.out.print("Enter Criminal Dob(DD-MM-YYYY)");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Date dob =Date.valueOf(LocalDate.parse(sc.next(), formatter));
	System.out.print("Enter Gender");
	 String gender=sc.next();
	sc.nextLine();
	System.out.print("Enter Identifying Mark");
	String identifyingMark=sc.nextLine();
	
	System.out.print("Enter Criminal firstArrestDate (DD-MM-YYYY)");
	Date firstArrestDate =Date.valueOf(LocalDate.parse(sc.next(), formatter));
	 
	PsAreaService pas = new PsAreaServiceImpl();
	List<PsArea> list =null;
	try {
		list = pas.getPsAreaList();
		if(list==null) {
			System.out.println("No police Station Area Available");
			return;
		}
		list.forEach(el->System.out.println(el.getId()+"."+el.getAreaName()));
		System.out.print("Enter Police Station Area Id");
		int psaid = sc.nextInt();
		PsArea psarea = null;
		for(PsArea li:list) {
			if(psaid==li.getId()) {
				psarea=li;
			}
		}
		if(psarea==null) {
			System.out.println("Invalid Ps Area Id");
			return;
		}
		Criminal criminal = new Criminal(criminalid, name, dob, gender, identifyingMark, firstArrestDate, psarea, null);
		CriminalService cs = new CriminalServiceImpl();
		cs.addCriminal(criminal);
		System.out.println("Criminal Added Successful");
	} catch (RecordNotFoundException | SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

public static void updateCriminalDetails(Scanner sc) {
	int choice=0;
	do {
		System.out.println("1. Update Criminal Name");
		System.out.println("2. Update Criminal Dob");
		System.out.println("3. Update Criminal Gender");
		System.out.println("4. Update Criminal identifying_mark");
		System.out.println("5. Update Criminal first_arrest_date");
		System.out.println("6. Update Criminal arrested_from_ps_area");
		System.out.println("0. Back");
		System.out.print("Selection Choice");
		choice = sc.nextInt();
		switch(choice) {
		case 1: updateCriminalName(sc);
			break;
		case 2:updateCriminalDob(sc);
			break;
		case 3:updateCriminalGender(sc);
			break;
		case 4:updateCriminalImark(sc);
			break;
		case 5:updateCriminalArrestDate(sc);
			break;
		case 6:updateCriminalArrestPsArea(sc);
		break;
		
		case 0:
			break;
		default:System.out.println("Invalid Selection");
		}
		
	}while(choice!=0);
	
}

private static void updateCriminalArrestPsArea(Scanner sc) {
	CriminalService cs = new CriminalServiceImpl();
	try {
		cs.getAllCriminal().forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		System.out.println("Enter Criminal Id");
		int criminalid=sc.nextInt();
		
		PsAreaService pas = new PsAreaServiceImpl();
		List<PsArea> list =null;
		
			list = pas.getPsAreaList();
			if(list==null) {
				System.out.println("No police Station Area Available");
				return;
			}
			list.forEach(el->System.out.println(el.getId()+"."+el.getAreaName()));
			System.out.print("Enter Police Station Area Id");
			int psaid = sc.nextInt();
			PsArea psarea = null;
			for(PsArea li:list) {
				if(psaid==li.getId()) {
					psarea=li;
				}
			}
			if(psarea==null) {
				System.out.println("Invalid Ps Area Id");
				return;
			}
		
		CriminalService csss =new CriminalServiceImpl();
		csss.updateCriminalPsArea(criminalid,psarea);
		System.out.println("Updated Successful");
	} catch (RecordNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
	
	
}
	

private static void updateCriminalArrestDate(Scanner sc) {
	CriminalService cs = new CriminalServiceImpl();
	try {
		cs.getAllCriminal().forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		System.out.println("Enter Criminal Id");
		int criminalid=sc.nextInt();
		System.out.println("Enter Criminal Arrest Date DD-MM-YYYY");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Date arrestDate =Date.valueOf(LocalDate.parse(sc.next(), formatter));
		
		CriminalService csss =new CriminalServiceImpl();
		csss.updateCriminalArrestDate(criminalid,arrestDate);
		System.out.println("Updated Successful");
	} catch (RecordNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
}

private static void updateCriminalImark(Scanner sc) {
	CriminalService cs = new CriminalServiceImpl();
	try {
		cs.getAllCriminal().forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		System.out.println("Enter Criminal Id");
		int criminalid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Criminal Identification Mark");
		String mark = sc.nextLine();
		
		CriminalService csss =new CriminalServiceImpl();
		csss.updateCriminalImark(criminalid,mark);
		System.out.println("Updated Successful");
	} catch (RecordNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

private static void updateCriminalGender(Scanner sc) {
	CriminalService cs = new CriminalServiceImpl();
	try {
		cs.getAllCriminal().forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		System.out.println("Enter Criminal Id");
		int criminalid=sc.nextInt();
		System.out.println("Enter Criminal Gender");
		String gender = sc.next();
		
		CriminalService csss =new CriminalServiceImpl();
		csss.updateCriminalGender(criminalid,gender);
		System.out.println("Updated Successful");
	} catch (RecordNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

private static void updateCriminalDob(Scanner sc) {
	CriminalService cs = new CriminalServiceImpl();
	try {
		cs.getAllCriminal().forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		System.out.println("Enter Criminal Id");
		int criminalid=sc.nextInt();
		System.out.println("Enter Criminal Dob DD-MM-YYYY");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Date dob =Date.valueOf(LocalDate.parse(sc.next(), formatter));
		
		CriminalService csss =new CriminalServiceImpl();
		csss.updateCriminalDob(criminalid,dob);
		System.out.println("Updated Successful");
	} catch (RecordNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

private static void updateCriminalName(Scanner sc) {
	
	CriminalService cs = new CriminalServiceImpl();
	try {
		cs.getAllCriminal().forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		System.out.println("Enter Criminal Id");
		int criminalid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Criminal Name");
		String name = sc.nextLine();
		CriminalService csss =new CriminalServiceImpl();
		csss.updateCriminalName(criminalid,name);
		System.out.println("Updated Successful");
	} catch (RecordNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

public static void AssignCriminalToCrime(Scanner sc) {
	try {
		CriminalService criSer = new CriminalServiceImpl();
		CrimeService cs = new CrimeServiceImpl();
		List<Crime> listCrime = cs.getAllCrime();
		listCrime.forEach(el->System.out.println(el.getCrimeId()+". "+el.getDescription()+" "+el.getType()));
		System.out.println("Please Enter Crime Id");
		int crimeid = sc.nextInt();
		Crime crime = null; 
		for(Crime li:listCrime) {
			if(li.getCrimeId()==crimeid) {
				crime = li;
			}
		}
		if(crime==null) {
			System.out.println("Invalid Crime Id");
			return;
		}
		List<Criminal> listCriminal = criSer.getAllCriminal();
		listCriminal.forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		System.out.println("Enter Criminal Id");
		int criminalId = sc.nextInt();
		Criminal criminal = null;
		for(Criminal li:listCriminal) {
			if(li.getCriminalId()==criminalId) {
				criminal = li;
			}
		}
		if(criminal==null) {
			System.out.println("Invalid Criminal Id");
			return;
		}
		
		
		
		
		CrimeService cservice = new CrimeServiceImpl();
		cservice.assingCriminal(crimeid,criminal);
		
		System.out.println("Assign successful");
	} catch (SomethingWentWrongException | RecordNotFoundException e) {
		System.out.println(e.getMessage());
	}
	
}

public static void removeCriminalFromCrime(Scanner sc) {
	try {
		CriminalService criSer = new CriminalServiceImpl();
		CrimeService cs = new CrimeServiceImpl();
		List<Crime> listCrime = cs.getAllCrime();
		listCrime.forEach(el->System.out.println(el.getCrimeId()+". "+el.getDescription()+" "+el.getType()));
		System.out.println("Please Enter Crime Id");
		int crimeid = sc.nextInt();
		Crime crime = null; 
		for(Crime li:listCrime) {
			if(li.getCrimeId()==crimeid) {
				crime = li;
			}
		}
		if(crime==null) {
			System.out.println("Invalid Crime Id");
			return;
		}
		Set<Criminal> listCriminal = crime.getCriminals();
		
		listCriminal.forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		
		System.out.println("Enter Criminal Id");
		int criminalId = sc.nextInt();
		Criminal criminal = null;
		for(Criminal li:listCriminal) {
			if(li.getCriminalId()==criminalId) {
				criminal = li;
			}
		}
		if(criminal==null) {
			System.out.println("Invalid Criminal Id");
			return;
		}
		
		
		
		
		CrimeService cservice = new CrimeServiceImpl();
		cservice.removeCriminalFromCrime(crime,criminal);
		
		System.out.println("Remove successful");
	} catch (SomethingWentWrongException | RecordNotFoundException e) {
		System.out.println(e.getMessage());
	}
	
}

public static void deleteCrimeById(Scanner sc) {
	
    try {
    	CriminalService criSer = new CriminalServiceImpl();
		CrimeService cs = new CrimeServiceImpl();
		List<Crime> listCrime = cs.getAllCrime();
		listCrime.forEach(el->System.out.println(el.getCrimeId()+". "+el.getDescription()+" "+el.getType()));
		System.out.println("Please Enter Crime Id");
		int crimeid = sc.nextInt();
    	
        CrimeService css = new CrimeServiceImpl();
		css.deleteCrimeById(crimeid);
		System.out.println("Deleted successful");
	} catch (SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}

public static void deleteCriminalById(Scanner sc) {
	CriminalService criSer = new CriminalServiceImpl();
	List<Criminal> listCriminal;
	try {
		listCriminal = criSer.getAllCriminal();
		listCriminal.forEach(el->System.out.println(el.getCriminalId()+". "+el.getName()));
		System.out.println("Enter Criminal Id");
		int criminalId = sc.nextInt();
		criSer.deleteCriminalById(criminalId);
		System.out.println("Deleted Successful");
	} catch (RecordNotFoundException | SomethingWentWrongException e) {
		System.out.println(e.getMessage());
	}
	
}
}
