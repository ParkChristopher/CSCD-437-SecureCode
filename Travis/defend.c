#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>



int getNum()
{
	
	
	char buffer[10000];
	do{
	printf("Please enter the number: ");
	scanf("%s", buffer);
	//printf("Size: %d", strlen(buffer));
		
		if(strspn(buffer, "0123456789") == strlen(buffer))
		{
			long result;
			errno = 0;
			
			result = strtol(buffer, 0, 10);
			if(result<INT_MAX)
			{
				return (int) result;
				
			}
				
			else
				printf("That number is too large for an int.");
			
		}
		else
			printf("Invalid input, try again: ");
	}while(1);
		
	
}

int canUseNums(int num1,int num2)
{
	if((long)(num1+num2) <0 && (num1>0 || num2>0))
	{
		printf("These numbers are too large to be added together, try again: \n");
		return 0;
		
	}	
	
	else if((long)(num1*num2)<0 && (num1>0 || num2>0))
	{
		printf("These numbers are too large to be multiplied, try again\n");
		return 0;
	}
	
	else
		return 1 ;
}


		
	
	
	
	



int main()
{
	int num1,num2;
	do
	{
    num1 =getNum() ;
    num2 = getNum();
	printf("%d",num1);
	printf("%d",num2);
	}while(!canUseNums(num1,num2));
	printf("Int: %d", num1*num2);
	
	
	
	return 1;
}





