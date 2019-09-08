package test;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

class Request{
	private final String name;
	
	public Request(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "[ Request " + this.name + " ]";
	}
}

class RequestQueue{
	private final Queue<Request> queue = new LinkedList<Request>();
	
	public synchronized Request getRequest() {
		/**
		 * peek(): return the first element in the queue,
		 * otherwise return null.
		 * 
		 * remove(): delete the first element and return,
		 * if the queue is empty, then throws "NoSuchElementException" 
		 */
		while(queue.peek() == null) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		return queue.remove();
	}
	
	public synchronized void putRequest(Request request) {
		/**
		 * offer(): add an element into the queue and return true,
		 * if the queue is full, then return false
		 */
		queue.offer(request);
		notifyAll();
	}
}

class ClientThread extends Thread{
	private final Random random;
	private final RequestQueue requestQueue;
	
	public ClientThread(RequestQueue requestQueue, String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}
	
	public void run() {
		for(int i = 0; i < 10000; i++) {
			Request request = new Request("No. " + i);
			System.out.println(Thread.currentThread().getName() + " requests " + request.toString());
			requestQueue.putRequest(request);
			try {
				Thread.sleep(random.nextInt(1000));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class ServerThread extends Thread{
	private final Random random;
	private final RequestQueue requestQueue;
	
	public ServerThread(RequestQueue requestQueue, String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}
	
	public void run() {
		for(int i = 0;i < 10000; i++) {
			Request request = requestQueue.getRequest();
			System.out.println(Thread.currentThread().getName() + " handles " + request.toString());
			try {
				Thread.sleep(random.nextInt(1000));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Request_between_server_and_client{
	public static void main(String args[]) {
		RequestQueue requestQueue = new RequestQueue();
		new ClientThread(requestQueue, "Alice", 3141692L).start();
		new ServerThread(requestQueue, "Bobby", 6535897L).start();
	}
}
