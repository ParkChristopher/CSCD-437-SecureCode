#include <stdio.h>
#include <string.h>
void foo()
{
  printf("did this work");
}

int main()
{
    
    printf("Address of foo = %p\n", foo);
	int x = 0;
    scanf("%d", &x);
    return 0;
}
