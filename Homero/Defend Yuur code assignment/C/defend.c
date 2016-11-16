/**
Chris Park
Travis Landers
Homero Gonzalez
Secure Code Assn. 6
Defend Your Code
*/

#include <stdlib.h>
#include <stdio.h>
#include <regex.h>
#include <string.h>
#include <errno.h>
#include <limits.h>
#include <math.h>
#include "Whirlpool.c"



#define  MAX_STRING 60

/*gcc -pedantic -Wall -Wextra -Werror yourFile.c*/

int get_num();
int can_use_nums(int num1,int num2);
void get_string(char* type, char* str);
void debug_printf(char* str, int result);
void truncate_input(char* str, char target);
void get_filename(char* type, char* str);
void write_to_ouput(char* filename, char* first_name,
				    char* last_name, int num_1, int num_2);
void get_password(char* type, char* str);
void get_password2(char* type, char* str);

int main()
{
	int num1, num2;
	char first_name[51];
	char last_name[51];
	char infile_name[51];
	char outfile_name[51];
	char password_one[51];
	char password_two[51];
	
	get_string("first name", first_name);
	get_string("last name", last_name);

	do
	{
		num1 = get_num();
		num2 = get_num();
	} while(!can_use_nums(num1, num2));
	
	do
	{
		get_filename("input", infile_name);
		get_filename("output", outfile_name);
		if(strcmp(infile_name, outfile_name)==0)
			printf("The file names cannot be the same, please try again\n");
		if(strcmp(infile_name,"test.txt")==0 || strcmp(outfile_name,"test.txt")==0 || strcmp(infile_name,"test2.txt")==0 || strcmp(outfile_name,"test2.txt")==0)
			printf("The file names cannot be test.txt or test2.txt, please try again\n");
	}while(strcmp(infile_name, outfile_name)==0 || strcmp(infile_name,"test.txt")==0 || strcmp(outfile_name,"test.txt")==0 || strcmp(infile_name,"test2.txt")==0 || strcmp(outfile_name,"test2.txt")==0);


	get_password("",password_one);
	get_password2("re",password_two);
	
	/*
	* Get Password
	* Verify Password
	* Get Input file
	* Write to Ouput
	*/
	return 0;
}



/**
* Get a string from the user, String should be
* between 1 and 50 alpha characters.
*/
void get_password(char* type, char* str)
{
	int length; 
	int is_locked = 1;
	char input[51];
	char* token;
	regex_t pattern;
	
	regcomp(&pattern, "^[a-zA-Z0-9!?]{1,50}$", REG_EXTENDED);

	while(is_locked)
	{
		printf("Please %senter a password:\r\n", type);
		printf("(Allowed: ?!, A-Z, a-z, 0-9): ");
		
		
		if(fgets(input, (sizeof(input) - 1), stdin))
		{
			if(!strchr(input, '\n'))
				while(fgetc(stdin)!='\n');

			token = strtok(input, "\n");

			if(token != NULL)
			{
				printf("String is: %s\r\n", token);
			
				if(!regexec(&pattern, token, 0, 0 , 0)) is_locked = 0;
				else printf("Invalid Input\r\n");
			}
			else printf("Invalid Input\r\n");
		}
		else printf("Invalid Input\r\n");
	}

	length = strlen(token);
	strncpy(str, token, length);
	
	
	// password encryption 
	
	struct NESSIEstruct w;
    u8 digest[DIGESTBYTES];
    static u8 data[1000000];

    memset(data, 0, sizeof(data));
	
	
	NESSIEinit(&w);
    NESSIEadd((unsigned char*)str, 8*length, &w);
    NESSIEfinalize(&w, digest);
	display(digest, DIGESTBYTES,1);
	
	
	regfree(&pattern);
}

void get_password2(char* type, char* str)
{int length; 
	int is_locked = 1;
	char input[51];
	char* token;
	regex_t pattern;
	
	struct NESSIEstruct w;
    u8 digest[DIGESTBYTES];
    static u8 data[1000000];
	memset(data, 0, sizeof(data));
 
	regcomp(&pattern, "^[a-zA-Z0-9!?]{1,50}$", REG_EXTENDED);

	while(is_locked)
	{
		printf("Please %senter a password:\r\n", type);
		printf("(Allowed: ?!, A-Z, a-z, 0-9): ");
		
		
		if(fgets(input, (sizeof(input) - 1), stdin))
		{
			if(!strchr(input, '\n'))
				while(fgetc(stdin)!='\n');

			token = strtok(input, "\n");

			if(token != NULL)
			{
				printf("String is: %s\r\n", token);
			
				if(!regexec(&pattern, token, 0, 0 , 0)) 
				{
					length = strlen(token);
					strncpy(str, token, length);

					NESSIEinit(&w);
    				NESSIEadd((unsigned char*)str, 8*length, &w);
    				NESSIEfinalize(&w, digest);
					display(digest, DIGESTBYTES,2);
					
					if(compHash(DIGESTBYTES) == 0)
					{
						printf("Password Verified\n");
						is_locked = 0;
					}	
 					else if(compHash(DIGESTBYTES) == -1)
					{
						printf("Files where either corrupted of tampered with. now exiting");
						return;
					}
					else printf("Password is incorrect, please try to verify again\r\n");
					
					
				}else printf("Invalid Input\r\n");
			}
			else printf("Invalid Input\r\n");
		}
		else printf("Invalid Input\r\n");
	}

	regfree(&pattern);
}
	


void get_string(char* type, char* str)
{
	int length; 
	int is_locked = 1;
	char input[51];
	char* token;
	regex_t pattern;
	
	regcomp(&pattern, "^[a-zA-Z]{1,50}$", REG_EXTENDED);

	while(is_locked)
	{
		printf("Please enter a %s. \r\n", type);
		printf("Names greater than 50 characters will be truncated: ");
		
		if(fgets(input, (sizeof(input) - 1), stdin))
		{
			if(!strchr(input, '\n'))
				while(fgetc(stdin)!='\n');

			token = strtok(input, "\n");

			if(token != NULL)
			{
				printf("String is: %s\r\n", token);
			
				if(!regexec(&pattern, token, 0, 0 , 0)) is_locked = 0;
				else printf("Invalid Input\r\n");
			}
			else printf("Invalid Input\r\n");
		}
		else printf("Invalid Input\r\n");
	}

	length = strlen(token);
	strncpy(str, token, length);
	regfree(&pattern);
}

/**
* Gets a file name from the user. Must be .txt format
*/
void get_filename(char* type, char* str)
{
	int length;
	int is_locked = 1;
	char input[51];
	char* token;
	regex_t pattern;
	
	regcomp(&pattern, "^([a-zA-Z0-9])+\\.txt$", REG_EXTENDED);
	
	while(is_locked)
	{
		printf("Please enter an %s .txt file: ", type);
		
		if(fgets(input, (sizeof(input) - 1), stdin))
		{
			if(!strchr(input, '\n'))
				while(fgetc(stdin)!='\n');

			token = strtok(input, "\n");

			if(token != NULL)
			{
				printf("Filename is: %s\r\n", token);

				if(!regexec(&pattern, token, 0, 0 , 0)) is_locked = 0;
				else printf("Invalid Input\r\n");
			}
			else printf("Invalid Input\r\n");
		}
		else printf("Invalid Input\r\n");
	}

	length = strlen(token);
	strncpy(str, token, length);
	regfree(&pattern);
}

/**
* Get a 32 Bit Integer
*/
int get_num()
{
	char input[11];
	char* token;
	long num;
	int result;
	regex_t pattern;
	
	regcomp(&pattern, "^([0-9]){1,10}$", REG_EXTENDED);

	do
	{
		printf("Please enter a 32 bit number,\r\n"); 
		printf("larger values will be truncated if possible: ");
		fgets(input, sizeof(input), stdin);

		if(!strchr(input, '\n'))
			while(fgetc(stdin)!='\n');
		
		token = strtok(input, "\n");

		if(token != NULL)
		{
			printf("Number is: %s\r\n", token);
			
			if(!regexec(&pattern, token, 0, 0 , 0))
			{
				num = strtol(input, 0, 10);
				
				if(num < INT_MAX && num > INT_MIN)
				{
					result = (int) num;
					regfree(&pattern);
					return result;
				}
				else printf("That number is too large. Can't be truncated.\r\n");
			}
			else printf("Invalid input\r\n");
		}
		else printf("Invalid input\r\n");
		
	} while(1);
}

/**
* Check for arithmetic overflow.
*/
int can_use_nums(int num1,int num2)
{
	long val_check;

	if(num1 > 0 && num2 > 0)
	{
		val_check = num1 + num2;

		if(val_check < 0)
		{
			printf("Addition operation not allowed: Causes an overflow.\n");
			return 0;
		}
	}
	else if(num1 < 0 && num2 < 0)
	{
		val_check = num1 + num2;

		if(val_check > 0)
		{
			printf("Addition operation not allowed: Causes an overflow.\n");
			return 0;
		}
	}
	else 
	{
		val_check = num1 * num2;

		if(val_check > INT_MAX || val_check < INT_MIN)
		{
			printf("Multiplication operation not allowed. Causes an overflow");
			return 0;
		}
	}

	return 1;
}


/*
* Read Input File
open input file
read characters into buffer, set a maximum buffer full check
*/

/*
* Write To Output
*/
void write_to_ouput(char* filename, char* first_name,
 					char* last_name, int num_1, int num_2)
{
	FILE* out_file = fopen(filename, "a");

	if(out_file == NULL) printf("File not opened.\r\n");
	
	/*Null terminate all strings*/

	/*Ouput name*/
	fputs(first_name, out_file);
	fputc('\n', out_file);
	fputs(last_name, out_file);
	fputc('\n', out_file);

	/*Ouput integer addition*/
	fprintf(out_file, "%d", (num_1 + num_2));
	fputc('\n', out_file);
	/*Output multiplication*/
	fprintf(out_file, "%d", (num_1 * num_2));
	fputc('\n', out_file);
	/*Output input file*/
	

	fclose(out_file);
}


	

/*
* For Debugging Return Values.
*/
void debug_printf(char* str, int result)
{
	if(!result) printf("%s [%d] success.\r\n", str, result);
	else 	  	printf("%s [%d] failure.\r\n", str, result);
}
