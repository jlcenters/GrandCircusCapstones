package week2capstone;

import java.text.*;
import java.util.*;

public class Validator {



//GET AN INTEGER
	public static int getInt(Scanner scnr, String prompt) {
		while (!scnr.hasNextInt()) {
			scnr.nextLine(); 
			System.out.println(prompt);
		}
		int result = scnr.nextInt();
		scnr.nextLine(); 
		return result;
	}

	
	
//GET A STRING
	public static String getString(Scanner scnr, String prompt) {
	System.out.print(prompt);
		return scnr.nextLine();
	}
	
	

//GET YES OR NO
	public static String getYesNo(Scanner scnr, String prompt) {
		boolean isValid = false;
		String input;
		do {
			input = getString(scnr,prompt);

			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")){
				isValid = true;
			} else {
				System.out.print("\nPlease enter \"YES\" or \"NO\". ");
				isValid = false;
			}

		} while (!isValid);
		
		return input;
	}
	
	
	
//GET PROPER DATE FORMAT
	public static String getDate(Scanner scnr, String prompt) {
	boolean isValid = false;
	String date;
	do {
		date = getString(scnr,prompt);
		isValid = true;
	try {
		Date correctDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
	}catch(ParseException pe) {
		isValid = false;
		System.out.print("");
			System.out.print("Please use [MM/DD/YYYY] formatting: ");
		}
	
	
	}while(!isValid);
	
	return date;
	}
	
	
	
//GET CORRECT MENU NUMBER
	public static int getMenuNum(Scanner scnr, String prompt,int min,int max) {
		boolean isValid = false;
		String userInput = "";
		int num = 0;
		do {
			try {
			num = scnr.nextInt();
			isValid = true;
		}catch(InputMismatchException im) {
			userInput = scnr.nextLine();
			if(userInput.equalsIgnoreCase("quit")) {
				userInput = getYesNo(scnr, "Unsaved progress will be lost. Are you sure you wish to quit? ");
				if(userInput.equalsIgnoreCase("yes")) {
					num = 0;
					return num;
				}else {
					System.out.print(prompt);
				}
			}else {
				System.out.print(prompt);
			}
			
			continue;
		}
			
			if (num < min || num > max) {
				isValid = false;
				scnr.nextLine();
				System.out.print("Please enter a number between " + min + " and " + max + ": ");
			}else {
				scnr.nextLine();
				isValid = true;
			}
		}while(!isValid);
		
		return num;
	}
	
}