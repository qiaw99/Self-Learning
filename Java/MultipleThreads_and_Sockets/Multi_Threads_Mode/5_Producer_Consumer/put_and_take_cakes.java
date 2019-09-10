package test;

import java.util.Random;

class MakerThread extends Thread{
	private final Random random;
	private static int id = 0;	// all the maker share this id
	private final Table table;
	
	public MakerThread(String name, Table table, long seed) {
		super(name);
		this.table = table;
		this.random = new Random(seed);
	}
	
	public void run() {
		try {
			while(true) {
				Thread.sleep(random.nextInt(1000));
				String cake = "[Cake No." + nextId() + " by" + getName() + " ]";
				table.put(cake);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static synchronized int nextId() {
		return id++;
	}
}

class EaterThread extends Thread{
	private final Random random;
	private Table table;
	
	public EaterThread(String name, Table table, long seed) {
		super(name);
		this.table = table;
		this.random = new Random(seed);
	}
	
	public void run() {
		try {
			while(true) {
				String cake = table.take();
				Thread.sleep(random.nextInt(1000));
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Table{
	private final String[] buffer;
	private int tail;
	private int head;
	private int count;
	
	public Table(int count) {
		this.buffer = new String[count];
		this.head = 0;
		this.count = 0;
		this.tail = 0;
	}
	
	public synchronized void put(String cake) throws InterruptedException{
		System.out.println(Thread.currentThread().getName() + " puts" + cake);
		while(count >= buffer.length) {
			wait();
		}
		buffer[tail] = cake;
		tail = (tail + 1) % buffer.length;
		count++;
		notifyAll();
	}
	
	public synchronized String take() throws InterruptedException{
		while(count <=0) {
			wait();
		}
		String cake = buffer[head];
		head = (head + 1) % buffer.length;
		count--;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " takes" + cake);
		return cake;
	}
}

public class put_and_take_cakes{
	public static void main(String args[]) {
		Table table = new Table(3);
		new MakerThread("MakerThread-1", table, 31415).start();
		new MakerThread("MakerThread-2", table, 92653).start();
		new MakerThread("MakerThread-3", table, 58979).start();
		new EaterThread("EaterThread-1", table, 32384).start();
		new EaterThread("EaterThread-2", table, 62643).start();
		new EaterThread("EaterThread-3", table, 38327).start();
	}
}
