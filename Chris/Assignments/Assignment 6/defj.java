//Secure Code Assignment 6
//Chris Park

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.math.BigInteger;
import java.lang.Exception;

public class defj{

	public static void main(String[] args){
		
		Scanner scan;
		PrintWriter writer;
		String firstName, lastName, inFileName, outFileName;
		long val1, val2;
		
		scan = new Scanner(System.in);
		
		firstName = getString("first name", scan);
		lastName = getString("last name", scan);
		val1 = getInt(scan);
		val2 = getInt(scan);
		inFileName = getFileName("input", scan);
		outFileName = getFileName("output", scan);
		//Get Password
		//Verify Password
		//Write to ouput
		scan.close();
	}
	
	/**
	* First Name, Last Name
	*/
	public static String getString(String type, Scanner scan){
		
		String input = "";
		boolean done = false; 
		Pattern pattern = Pattern.compile("^([a-zA-Z\\-]){1,50}$");
		
		while(!done){
			
			System.out.print("Please enter " + type +":");
			input = scan.next();
			
			if(isMatched(input, pattern)) done = true;
			else {
				
				System.out.print("Invalid input:");
				System.out.println("Expected alphabetic not exceeding 50 characters. ");
			}
		}
		
		return input;
	}
	
	/**
	* Integers
	*/
	public static long getInt(Scanner scan){
		
		BigInteger bigInt;
		long val = 0;
		boolean done = false;
		
		
		while(!done){
			
			System.out.print("Please enter a value: ");
			
			try{
				
					bigInt = BigInteger.valueOf(scan.nextInt());
					
					if(bigInt.bitLength() > 31) throw new IllegalArgumentException();
					
					val = bigInt.longValue();
					done = true;
			}
			catch(Exception e){
				
				System.out.print("Invalid input:");
				System.out.println("Expected 32 bit integer.");
			}
		}
		
		return val;
	}

	/**
	* File Name
	*/
	public static String getFileName(String type, Scanner scan){
		
		String input = "";
		boolean done = false; 
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\-_]+.{1}txt$");
		
		while(!done){
			
			System.out.print("Please enter  an " + type + " file name: ");
			input = scan.next();
			
			if(isMatched(input, pattern)) done = true;
			else {
				
				System.out.print("Invalid input:");
				System.out.print("Expected valid .txt file name made up of characters,");
				System.out.println("numbers, and (-_). Example: <my-file_name9.txt>");
			}
		}
		
		return input;
	}


//get a password from the user
//minimum x characters
//upper case, lower case, punctuation, numeric
//salt and hash
//get verification after entering
	
	//Password
	public static void getPassword(Scanner scan){
		// While not done
			// Get password
				//	If password passes regex
					//salt and hash it
					//ask for verification (Re-entry of password)
			//if verification passed
				//store (how?)
	}
	
	//Verify Password
	public static void verifyPassword(Scanner scan){
		
	}
	

//open output file and write:
//user name
//result of addition and multiplying the integer values
//contents of input file

	
	public static void writeToOutput(Scanner scan, FileWriter outFile){
		
	}

	public static boolean isMatched(String str, Pattern pattern){
	
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}