//Secure Code Assignment 6
//Chris Park

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.lang.Exception;
import java.security.SecureRandom;

public class defj{

	public static void main(String[] args){
		
		Scanner scan;
		PrintWriter writer;
		String firstName, lastName, inFileName, outFileName;
		int val_array[] = new int[2];
		
		scan = new Scanner(System.in);
		
		firstName = getString("first name", scan);
		lastName = getString("last name", scan);
		getInt(val_array, scan);
		inFileName = getFileName("input", scan);
		outFileName = getFileName("output", scan);
		getPassword(scan);
		verifyPassword(scan);
		
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
	public static void getInt(int[] nums, Scanner scan){
		
		long val = 0;
		boolean done = false;
		int temp;
		
		do{
			System.out.print("Enter your first 32bit number: ");
			
			while(!scan.hasNextInt()){
				
				System.out.print("Enter your first 32bit number: ");
				scan.next();
			}
			
		nums[0] = scan.nextInt();
		
		System.out.print("Enter your second 32bit number: ");
		
		while(!scan.hasNextInt()){
			
				System.out.print("Enter your first 32bit number: ");
				scan.next();
			}
			
			nums[1] = scan.nextInt();
		
		}while(!check(nums));
	}

	/**
	* helper function for number verification and overflow
	*/
	private static boolean check(int[] numbers)
	{
		if(numbers[0]>=0 && numbers[1]>=0)
		{
			if(numbers[0] + numbers[1] < 0)
			{
				System.out.println("Number combinations are invalid");
				return false;
			}
			else if(numbers[0] * numbers[1] < 0)
			{
				System.out.println("Number combinations are invalid");
				return false;
			}
		}
		
		else if(numbers[0]<=0 && numbers[1]<=0)
		{
			if(numbers[0] + numbers[1] > 0)
			{
				System.out.println("Number combinations are invalid");
				return false;
			}
			else if(numbers[0] * numbers[1] < 0)
			{
				System.out.println("Number combinations are invalid");
				return false;
			}
		}
		
		else if(numbers[0]<=0 && numbers[1]>=0 || numbers[0]>=0 && numbers[1]<=0)
		{
			 if(numbers[0] * numbers[1] >= 0)
			{
				System.out.println("Number combinations are invalid");
				return false;
			}
		}
		return true;
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

//Password
   public static void getPassword(Scanner scan){
   	// While not done
   		// Get password
   			//	If password passes regex
   				//salt and hash it
   				//ask for verification (Re-entry of password)
   		//if verification passed
   			//store (how?)
           
      String input = "";
      boolean done = false; 
      Pattern pattern = Pattern.compile("^[A-Za-z0-9!?]{1,}$");
      scan.nextLine();
      while(!done){
      	
         System.out.print("Please enter your password");
         input = scan.nextLine();
      	
         if(isMatched(input, pattern)) done = true;
         else {
         	
            System.out.println("Invalid input:");
            System.out.println("Your password need to contain a upper case, lower case, punctuation,and numeric value");
         	
         }
      }
      byte [] salt = new byte[input.length()];
      SecureRandom ran = new SecureRandom();
      ran.nextBytes(salt);
      input = salt + input;     
           
      byte [] hashedInput = new byte[input.length()+224];
   	
      Whirlpool w = new Whirlpool();
      w.NESSIEinit();
      w.NESSIEadd(input);
      w.NESSIEfinalize(hashedInput); 
      String hash = w.display(hashedInput);
      try{
         PrintWriter writer = new PrintWriter(new File("test.txt"));
         writer.println(salt);
         writer.println(hash);
         writer.close();
         
       }catch(IOException e) {}
   }
	
	//Verify Password
   public static void verifyPassword(Scanner scan){
   String salt = "";
   String password = "";
   
   try{
      Scanner file = new Scanner(new File("test.txt"));
      salt = file.nextLine();
      password = file.nextLine();
      file.close();
   }catch(IOException e) {}
   
      String input = "";
      boolean done = false; 
      Pattern pattern = Pattern.compile("^[A-Za-z0-9!?]{1,}$");
      
      while(!done){
      	
         System.out.print("Please re-enter your password for confirmation");
         input = scan.nextLine();
      	
         if(isMatched(input, pattern)) done = true;
         else {
         	
            System.out.println("Invalid input:");
            System.out.println("Your password need to contain a upper case, lower case, punctuation,and numeric value");
         	
         }
      }
      
      input = salt + input;     
           
      byte [] hashedInput = new byte[input.length()+224];
     
      Whirlpool w = new Whirlpool();
      w.NESSIEinit();
      w.NESSIEadd(input);
      w.NESSIEfinalize(hashedInput); 
      String hash = w.display(hashedInput);
      if(hash.compareTo(password)== 0)
      {
         System.out.println("PassWord has been Confirmed");
      }
      else
      {
         System.out.println("Passwords did not match");
      }
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