package test;
import java.lang.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class MyThread extends Thread{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("Nice ");
		}
	}
}

class PrintThread extends Thread{	
	private String message;
	
	public PrintThread(String message) {
		this.message = message;
	}
	
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(message);
		}
	}
}

class Printer implements Runnable{	
	private String message;
	
	public Printer(String message) {
		this.message = message;
	}
	
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(message);
		}
	}
}

public class Thread {
	public static void test_MyThread() {
		MyThread t = new MyThread();
		//启动新线程并且调用run()方法
		t.start();
		for(int i = 0; i < 1000; i++) {
			System.out.println("Good ");
		}
	}
	
	public static void test_PrintThread() {
		new PrintThread("Nice").start();
		new PrintThread("Good").start();
	}
	
	public static void test_Printer() {
		new Thread(new Printer("Good")).start();
		new Thread(new Printer("Nice")).start();
	}
	public static void test_ThreadFactory() {
		ThreadFactory factory = Executors.defaultThreadFactory();
		factory.newThread(new Printer("Nice")).start();
		for(int i = 0; i < 1000; i++) {
			System.out.println("Good");
		}
	}
	public static void main(String args[]) {
		test.test_ThreadFactory();
	}
}
