#include <stdio.h>
#include <stdlib.h>

#include "stdbool.h"

int a[10] = {0};

int L[8][3] ={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},
{3,6,9},{1,5,9},{3,5,7}}; 

bool XO_line[8] = {0};

int line_XO = 0; 

int f(int x){
	int x1 = a[L[x][0]];
	int x2 = a[L[x][1]];
	int x3 = a[L[x][2]];
	return x1*x2 + x2*x3 + x3*x1;
}

void printGame(){
	printf("+-+-+-+\n");
	for(int i = 1; i <= 9; i++){
		if(a[i] == 1){
			printf("X  ");
		}else if(a[i] == 2){
			printf("O  ");
		}else{
			printf("%d  ",i);
		}

		if(i % 3 == 0){
			printf("\n+-+-+-+\n");
		}
	}
}

char XO[] = {' ','X','O'};
void play(int player,int i){
	printGame();
	printf("Player = %d %c\n",player,XO[player]);
	do{
		do{
			printf("The number ");
			scanf("%d",&i);
		}while(i<1 || i>9);
	}while(a[i] != 0);
	a[i] = player;
	printGame();
	printf("======\n");
}

int who_wins(){
	for(int i = 0; i < 8; i++){
		int F = f(i);
		if(XO_line[i])
			continue;
		switch(F){
			case 3: printf("Player 1 wins\n"); return 1;
			case 12: printf("Player 2 wins\n"); return 2;
			case 2: case 5: case 8:
				XO_line[i] = 1;
				line_XO++;
				if(line_XO == 8){
					printf("Draw.\n");
					return 3;
				}
		}
	}
	return 0;
}

int main(void){
	who_wins();

	int i = 0;
	int winner = 0;
	play(1,i);
	for(int j = 2; j <= 9; j += 2){
		play(2,i);
		winner = who_wins();
		if(winner != 0){
			break;
		}
		play(1,i);
		winner = who_wins();
		if(winner != 0){
			break;
		}
	}
	return 0;
}
