#include <stdio.h>
#include <stdlib.h>

int main(){
	int* a = malloc(100*sizeof(int));
	//std::cout<<sizeof(a)<<std::endl;
	printf("%lu\n", sizeof(*a));
	a[1111]=7;
	for(int i = 0; i < 121; i++){
		*(a+i)=i*3;
		//printf("a[%d] = %d\n", i, a[i]);
		printf("a[%d] = %d\n", i, *(a+i));
	}
	//free(a);
	//a = calloc(100,sizeof(int));
	//realloc(200,sizeof(int));
	a = malloc(200*sizeof(int));
	for(int i = 0; i < 200; i++){
		printf("a[%d] = %d\n", i, *(a+i));
	}
	free(a);
	return 0;
}
