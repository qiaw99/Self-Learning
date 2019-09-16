package test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ExecutorService;

class ClientThread extends Thread{
	private final ExecutorService executorService;
	private static final Random random = new Random();
	
	public ClientThread(String name, ExecutorService executorService) {
		super(name);
		this.executorService = executorService;
	}
	
	public void run() {
		try {
			for(int i = 0; true; i++) {
				Request request = new Request(getName(), i);
				executorService.execute(request);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(RejectedExecutionException e) {
			System.out.println(getName() + " : " + e);
		}
	}
}

class Request implements Runnable{
	private final String name;
	private final int number;
	private static final Random random = new Random();
	
	public Request(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executes " + this);
		try{
			Thread.sleep(random.nextInt(1000));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return "[ Request from" + name + " No." + number + " ]"; 
	}
}

public class ThreadPool{
	public static void main(String args[]) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		try {
			new ClientThread("Alice", executorService).start();
			new ClientThread("Bobby", executorService).start();
			new ClientThread("Chris", executorService).start();
			
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}
	}
}
