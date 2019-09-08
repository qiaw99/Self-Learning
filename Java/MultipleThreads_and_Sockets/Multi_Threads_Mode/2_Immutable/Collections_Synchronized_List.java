package test;

/**
 * @author qiaw99
 * remove(0): delete the first element in the List
 * add(i): add the element whose value equals i into the List
 */

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.concurrent.CopyOnWriteArrayList;

/*  if the class ArrayList loses the safety while multiple 
 *  threads are being written or read, it will throw 
 *  "ConcurrentModificationException" or "NullPointerException"
 */

class WriterThread extends Thread{
	private final List<Integer> list;
	
	public WriterThread(List<Integer> list) {
		super("WriterThread");		//create a thread which name is WriterThread
		this.list = list;
	}
	
	public void run() {
		for(int i = 0; true; i++) {
			list.add(i);
			list.remove(0);
		}
	}
}

class ReaderThread extends Thread{
	private final List<Integer> list;
	
	public ReaderThread(List<Integer> list) {
		super("ReaderThread");
		this.list = list;
	}
	
	public void run() {
		while(true) {
			synchronized(list) {
				for(int n : list) {
					System.out.println(n);
				}
			}
		}
	}
}

public class Collections_Synchronized_List{
	public static void main(String args[]) {
		final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		//final List<Integer> list = new CopyOnWriteArrayList<Integer>();
		new WriterThread(list).start();
		new ReaderThread(list).start();
	}
}
