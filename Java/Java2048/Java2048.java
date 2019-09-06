package qiaw99;

public class Java2048{
    public static void main(String args[]){
        Game g = new Game();
        g.printArray();
        for(int x = 0; x < 11;x++){
            g.addNewNumber();
            g.printArray();
        }
    }
}