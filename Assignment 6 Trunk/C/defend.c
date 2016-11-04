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

#define  MAX_STRING 60

/*gcc -pedantic -Wall -Wextra -Werror yourFile.c*/

int getNum();
int canUseNums(int num1,int num2);
void get_string(char* type, char* str);
void debug_printf(char* str, int result);
void truncate_input(char* str, char target);
void get_filename(char* type, char* str);

int main()
{
	int num1, num2;
	char first_name[50];
	char last_name[50];
	char infile_name[50];
	char outfile_name[50];
	
	get_string("first name", first_name);
	get_string("last name", last_name);
	


	do
	{
		num1 = getNum();
		num2 = getNum();
	} while(!canUseNums(num1, num2));
	debug_printf("Exit while loop in main, ", 0);
	
	get_filename("input", infile_name);
	get_filename("output", outfile_name);


	return 0;
}

/**
* Get a string from the user, String should be
* between 1 and 50 alpha characters.
*/
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
	
	regcomp(&pattern, "^[a-zA-Z0-9]+.{1}txt$", REG_EXTENDED);
	
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
int getNum()
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
					return result;
				}
				else printf("That number is too large. Can't be truncated.\r\n");
			}
			else printf("Invalid input\r\n");
		}
		else printf("Invalid input\r\n");
		
	} while(1);
	regfree(&pattern);
}

/**
* Check for arithmetic overflow.
*/
int canUseNums(int num1,int num2)
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

void debug_printf(char* str, int result)
{
	if(!result) printf("%s [%d] success.\r\n", str, result);
	else 	  	printf("%s [%d] failure.\r\n", str, result);
}



