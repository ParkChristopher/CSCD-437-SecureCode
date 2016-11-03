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

#define  MAX_STRING 60

/*gcc -pedantic -Wall -Wextra -Werror yourFile.c*/

int getNum();
int canUseNums(int num1,int num2);
void get_string(char* type, char* str);
void debug_printf(char* str, int result);


int main()
{
	int num1, num2;
	/*char first_name[50];*/
	/*
	char* last_name;
	char* in_file_name;
	char* out_file_name;
	*/
	
	/*get_string("first name", first_name);*/

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
	char raw_input[50];
	regex_t pattern;
	
	/*compiled_pattern = malloc(sizeof(regex_t));*/
	
	result = regcomp(&pattern, "^([a-zA-Z\\-])\\{1,50\\}$", REG_NOSUB);
	debug_printf("Pattern compile", result);
	
	while(is_locked)
	{
		
		printf("Please enter %s: ", type);
		
		if(fgets(raw_input, sizeof(raw_input), stdin))
		{

			/*Need to purge stdin here in case of extra user input*/

			printf("%s", raw_input);
			/*do checks here*/
			if(!regexec(&pattern, raw_input, 0, 0 , 0))
			{
				
				printf("Yep!\r\n");
				is_locked = 0;
			}
			else
			{
				printf("Invalid Input\r\n");
				printf("Expected alphabetic not exceeding 50 characters.\r\n");	
			}
		}
		else
		{
			printf("Invalid Input\r\n");
			printf("Expected alphabetic not exceeding 50 characters.\r\n");
		}
	}
	
	strncpy(str, raw_input, sizeof(raw_input));
	/*free(compiled_pattern);*/
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
	char buffer[20];
	long result;
	
	do
	{
		printf("Please enter a number: ");
		fgets(buffer, sizeof(buffer), stdin);
		
		
		if(!strchr(buffer, '\n'))
			while(fgetc(stdin)!='\n');
		
		if(strspn(buffer, "0123456789") <= strlen(buffer))
		{		
			debug_printf("Strspn", 0);	
			result = strtol(buffer, 0, 10);
			if((result < INT_MAX) || (result > INT_MIN))
				return (int) result;
			else 				
				printf("That number is too large for an int.");
		}
		else printf("Invalid input\n");
	} while(1);
}

int canUseNums(int num1,int num2)
{
	if((long)(num1+num2) <0 && (num1>0 || num2>0))
	{
		printf("These numbers are too large to be added together.\n");
		return 0;
	}	
	else if((long)(num1*num2)<0 && (num1>0 || num2>0))
	{
		printf("These numbers are too large to be multiplied,\n");
		return 0;
	}
	else return 1;
}


void debug_printf(char* str, int result)
{
	if(!result) printf("%s [%d] success.\r\n", str, result);
	else 	  	printf("%s [%d] failure.\r\n", str, result);
}



