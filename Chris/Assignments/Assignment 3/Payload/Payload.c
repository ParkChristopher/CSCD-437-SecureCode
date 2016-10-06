//Payload File
//Author: Chris Park

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void openShell();

int main(){
	
	printf("Address of openShell = %p\n", openShell);
	
	//openShell();
	return 0;
}

void openShell(){
	
	printf("All your base are belong to me...");
	//system("start cmd.exe");
}//end openShell