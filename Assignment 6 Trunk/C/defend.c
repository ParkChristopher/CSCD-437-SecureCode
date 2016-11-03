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


int main()
{
	int num1, num2;
	char first_name[50];
	/*
	char* last_name;
	char* in_file_name;
	char* out_file_name;
	*/
	
	get_string("first name", first_name);

	do
	{
		num1 = getNum();
		num2 = getNum();
	} while(!canUseNums(num1, num2));
	debug_printf("Exit while loop in main, ", 0);
	return 0;
}

/**
* Get a string from the user, String should be
* between 1 and 50 alpha characters.
*/
void get_string(char* type, char* str)
{
	int result;
	int is_locked = 1;
	char raw_input[51];
	regex_t pattern;
	
	result = regcomp(&pattern, "^([a-zA-Z]){1,50}", REG_EXTENDED);
	debug_printf("Pattern compile", result);
	
	while(is_locked)
	{
		printf("Please enter %s: ", type);
		
		if(fgets(raw_input, (sizeof(raw_input) - 1), stdin))
		{

			if(!strchr(raw_input, '\n'))
			{
				raw_input[49] = '\0';
				while(fgetc(stdin)!='\n');
			}
			
			printf("String is: %s\n", raw_input);

			
			if(!regexec(&pattern, raw_input, 0, 0 , 0))
			{
				
				debug_printf("Yep!\r\n", 0);
				is_locked = 0;
			}
			else
			{	

				printf("Invalid Input\r\n");
				printf("Expected alpha characters.\r\n");	
			}
		}
		else
		{
			printf("Outer Nope!\r\n");

			printf("Invalid Input\r\n");
			printf("Expected alpha characters.\r\n");
		}
	}
	
	strncpy(str, raw_input, sizeof(raw_input));
}

char* getFileName()
{
	return NULL;
}

/**
* Get a 32 Bit Integer
*/
int getNum()
{
	char raw_input[11];
	long input;
	int result;
	regex_t pattern;
	
	regcomp(&pattern, "^([0-9]){1,10}", REG_EXTENDED);

	do
	{
		printf("Please enter a 32 bit number,\n"); 
		printf("larger values will be truncated if possible: ");
		fgets(raw_input, sizeof(raw_input), stdin);

		if(!strchr(raw_input, '\n'))
		{
			raw_input[10] = '\0';
			while(fgetc(stdin)!='\n');
		}
		
		if(!regexec(&pattern, raw_input, 0, 0 , 0))
		{
			input = strtol(raw_input, 0, 10);
			
			if(input < INT_MAX && input > INT_MIN)
			{
				result = (int) input;
				printf("You Entered: %s\n", raw_input);
				return result;
			}
			else printf("That number is too large. Can't be truncated.\n");
		}
		else printf("Invalid input\n");
	} while(1);
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



