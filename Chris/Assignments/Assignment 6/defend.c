//Chris Park
//Secure Code Assn. 6

#include <stdlib.h>
#include <stdio.h>
#include <regex.h>

#define  MAX_STRING 60

char* get_string(char* type);
void debug_printf(char* str, int result);

int main(int argc, char* argv[])
{
	char* first_name;
	char* last_name;
	char* in_file_name;
	char* out_file_name;
	
	first_name = get_string("first name");
	
}

char* get_string(char* type)
{
	int result;
	int is_done = 1;
	char input[60];
	char* pattern = "^([a-zA-Z\\-]){1,50}$";
	regex_t compiled_pattern;
	
	result = regcomp(compiled_pattern, pattern, REG_NOSUB);
	debug_printf(result);
	
	
	while(done)
	{
		
		printf("Please enter %s: ", type);
		
		if(fgets(input, sizeof(input), stdin))
		{
			
		}
		else
		{
			printf("Invalid Input\r\n");
			printf("Expected alphabetic not exceeding 50 characters.");
		}
		
	}
	
	return input;

}

char* getFileName()
{
	
}


void debug_printf(char* str, int result)
{
	
	if(result) printf("%s success.\r\n", str )
	else 	  printf("%s failure.\r\n", str);
}



