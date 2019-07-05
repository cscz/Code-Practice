#include <stdio.h>
#include <stdlib.h>

struct LinkedList{
	int data;
	struct LinkedList *next;
};

typedef struct LinkedList *node;



int main(int argc, char* argv[]){
	node a,b,c;
	a = malloc(sizeof(struct LinkedList));
	b = malloc(sizeof(struct LinkedList));
	c = malloc(sizeof(struct LinkedList));
	a->data = 3;	
	b->data = 4;
	c->data = 5;
	a->next = b;
	b->next = c;
	printf("a=%d\n", a->data);
	printf("b=%d\n", a->next->data);
	printf("c=%d\n", a->next->next->data);
}
