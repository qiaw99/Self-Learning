package qiaw99;

import java.util.ArrayList;
import java.util.Random;

public class Game{
    private int[][] gameBoard;
    private Random r = new Random();

    public Game(){
        gameBoard = new int [4][4];
    }
    public void printArray(){
        for(int[] x : gameBoard){
            System.out.format("%6d%6d%6d%6d%n",x[0],x[1],x[2],x[3]);
        }
    }

    public void addNewNumber(){
        ArrayList<Integer> emptySpacesX = new ArrayList<Integer>();
        ArrayList<Integer> emptySpacesY = new ArrayList<Integer>();
        for(int x = 0;x < 4; x++){
            for(int y = 0; y < 4; y++){
                if(gameBoard[x][y] == 0){
                    emptySpacesX.add(new Integer(x));
                    emptySpacesY.add(new Integer(y));
                }
            }
        }
        int choice = r.nextInt(emptySpacesX.size());
        int numberChooser = r.nextInt(10); 		//value 0-9
        int newNumber = 1;
        if(numberChooser == 0){
            newNumber = 2;
        }
        int X = emptySpacesX.get(choice);
        int Y = emptySpacesY.get(choice);
        gameBoard[X][Y] = newNumber;
    }
}

