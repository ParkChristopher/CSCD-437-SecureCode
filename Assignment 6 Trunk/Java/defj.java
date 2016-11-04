//Secure Code Assignment 6
//Chris Park

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.math.BigInteger;
import java.lang.Exception;
import java.security.SecureRandom;

public class defj{

   public static void main(String[] args){
   	
      Scanner scan;
      PrintWriter writer = null;
      String firstName, lastName, outFileName;
      String inFileName = "";
      boolean isVerified = false;
   	int[] numbers;

      scan = new Scanner(System.in);
   	
      firstName = getString("first name", scan);
      lastName = getString("last name", scan);
      numbers = readNum(scan);
      inFileName = getFileName("input",inFileName,scan);
      outFileName = getFileName("output",inFileName, scan);
      getPassword(scan);

      while(!isVerified){
         isVerified = verifyPassword(scan);
      }
   	

      scan =  inputFileHookUp(scan,inFileName);
      writer = outputFileHookUp(writer,outFileName);
   	writeToOutput(scan, writer,numbers,firstName,lastName);
   }
	
	/**
	* First Name, Last Name
	*/
   public static String getString(String type, Scanner scan){
   	
      String input = "";
      boolean done = false; 
      Pattern pattern = Pattern.compile("^([a-zA-Z-]){1,50}$");
   	
      while(!done){
      	
         System.out.print("Please enter " + type +":");
         input = scan.next();
         System.out.println(input);
      	
         if(isMatched(input, pattern)) done = true;
         else {
         	
            System.out.print("Invalid input, ");
            System.out.println("Expected alphabetic not exceeding 50 characters. ");
         }
      }
   	
      return input;
   }
	
	/**
	* Integers
	*/
  
	private static int[] readNum(Scanner kb)
	{
		int [] numbers = new int[2];
		int temp;
		
		do
		{ 
			System.out.println("Enter Your first 32bit Number");
			while(!kb.hasNextInt())
			{
				System.out.println("Enter Your first 32bit Number");
				kb.next();
			}
			
			temp = kb.nextInt();
			
			numbers[0] = temp;
			
			System.out.println("Enter Your second 32bit Number");
			while(!kb.hasNextInt())
			{
				System.out.println("Enter Your second 32bit Number");
				kb.next();
			}
			
			temp = kb.nextInt();
			numbers[1] = temp;
			
		
		}while(!check(numbers));
		
		
		return numbers;
	}

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
   public static String getFileName(String type,String inputFileName, Scanner scan){
   	
      String input = "";
      boolean done = false; 
      Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\-_]+.{1}txt$");
   	
      while(!done){
      	
         System.out.print("Please enter  an " + type + " file name: ");
         input = scan.next();
      	
         if(isMatched(input, pattern))
         {
            if( input.compareTo("test.txt") == 0)
            {
               System.out.print("Invalid input:");
               System.out.println("File Name selected is not allowed");
            }
            else if(type.compareTo("output")==0)
            {
               if(inputFileName.compareTo(input)==0)
               {
                System.out.print("Invalid input:");
                System.out.println("File Name was selected as input file name");
               }
               else
                  done = true;
            }
            else 
               done = true;
         }
          
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
          
      String input = "";
      boolean done = false; 
      Pattern pattern = Pattern.compile("^[A-Za-z0-9!?]{1,}$");
      scan.nextLine();
      while(!done){
      	
         System.out.print("Please enter your password: ");
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
         
       }catch(IOException e)
       {
       }
         
   }
	
	//Verify Password
   public static boolean verifyPassword(Scanner scan){

   String salt = "";
   String password = "";
   
   try{
      Scanner file = new Scanner(new File("test.txt"));
      salt = file.nextLine();
      password = file.nextLine();
      file.close();
   }catch(IOException e)
   {}
   
      String input = "";
      boolean done = false; 
      Pattern pattern = Pattern.compile("^[A-Za-z0-9!?]{1,}$");
      
      while(!done){
      	
         System.out.print("Please re-enter your password for confirmation: ");
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
         System.out.println("Password confirmed.");
         return true;
      }
      else
      {
         System.out.println("Passwords did not match");
         return false;
      }
   }
	

//open output file and write:
//user name
//result of addition and multiplying the integer values
//contents of input file

   
	
   public static void writeToOutput(Scanner scan, PrintWriter outFile,int []numbers, String firstName,String lastName)
   {
      String transfer = "";
      outFile.println(firstName + " " + lastName);
   	outFile.println("Sum = " + (numbers[0] + numbers[1]));
      outFile.println("Product = " +numbers[0] * numbers[1]);
      
      if(scan != null)
      {
         while(scan.hasNextLine())
         {
            transfer = scan.nextLine();
            outFile.println(transfer);
            
         }
         scan.close();
         
      }
   outFile.close();
   }
   
   
//Hook Up scanner to read file
   public static Scanner inputFileHookUp(Scanner scan,  String input){
   
      try{
      
       scan = new Scanner(new File(input));
       
      
      }catch(IOException e)
      {
         return null;
      }
      return scan;
   }
   
//Hook up PrintWriter to write to file   
    public static PrintWriter outputFileHookUp(PrintWriter writer,  String output){
   
      try{
      
       writer = new PrintWriter(new File(output));

      }catch(IOException e){}
      
      return writer;
   }

   public static boolean isMatched(String str, Pattern pattern){
   
      Matcher matcher = pattern.matcher(str);
      return matcher.matches();
   }
}