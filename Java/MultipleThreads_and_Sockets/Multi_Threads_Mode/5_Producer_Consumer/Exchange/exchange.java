package test;

import java.util.concurrent.Exchanger;
import java.util.Random;

class ProducerThread extends Thread{
	private final Exchanger<char[]> exchanger;
	private char[] buffer = null;
	private char index = 0;
	private final Random random;
	
	public ProducerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
		super("ProducerThread");
		this.exchanger = exchanger;
		this.buffer = buffer;
		this.random = new Random(seed);
	}
	
	public void run() {
		try {
			while(true) {
				for(int i = 0; i < buffer.length; i++) {
					buffer[i] = nextChar();
					System.out.println(Thread.currentThread().getName() + ": " + buffer[i] + "-> ");
				} 
				
				System.out.println(Thread.currentThread().getName() + ": BEFORE exchange");
				buffer = exchanger.exchange(buffer);
				System.out.println(Thread.currentThread().getName() + ": AFTER exchanger");
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private char nextChar() throws InterruptedException{
		char c = (char)('A' + index % 26);
		index++;
		Thread.sleep(random.nextInt(1000));
		return c;
	}
}

class ConsumerThread extends Thread{
	private final Exchanger<char[]> exchanger;
	private char[] buffer = null;
	private final Random random;
	
	public ConsumerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
		super("ConsumerThread");
		this.exchanger = exchanger;
		this.buffer = buffer;
		this.random = new Random(seed);
	}
	
	public void run() {
		try {
			while(true) {
				System.out.println(Thread.currentThread().getName() + ": BEFORE exchange");
				buffer = exchanger.exchange(buffer);
				System.out.println(Thread.currentThread().getName() + ": AFTER exchange");
				
				for(int i = 0; i < buffer.length; i++) {
					System.out.println(Thread.currentThread().getName() + ": ->" + buffer[i]);
					Thread.sleep(random.nextInt(1000));
				}
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class exchange{
	public static void main(String args[]) {
		Exchanger<char[]> exchanger = new Exchanger<char[]> ();
		char[] buffer1 = new char[10];
		char[] buffer2 = new char[10];
		new ProducerThread(exchanger,buffer1,314159).start();
		new ConsumerThread(exchanger,buffer2,265358).start();
	}
}
