package test;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

class Log{
	private static PrintWriter writer = null;
	
	static {
		try {
			writer = new PrintWriter(new FileWriter("log.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void println(String s) {
		writer.print(s);
	}
	
	public static void close() {
		writer.println("==== End of log ====");
		writer.close();
	}
}

public class Test_Log{
	public static void main(String args[]) {
		System.out.println("BEGIN");
		for(int i = 0; i < 10; i++) {
			Log.println("main: i = " + i);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		Log.close();
		System.out.println("END");
	}
}
