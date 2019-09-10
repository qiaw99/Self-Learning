package test;

import java.util.concurrent.TimeoutException;

class Host{
	private final long timeout;
	private boolean ready = false;
	
	public Host(long timeout) {
		this.timeout = timeout;
	}
	
	public synchronized void setExecutable(boolean on) {
		ready = on;
		notifyAll();
	}
	
	public synchronized void execute() throws InterruptedException, TimeoutException{
		long start = System.currentTimeMillis();	//start time
		while(!ready) {
			long now = System.currentTimeMillis();	//current time
			long rest = timeout - (now - start);
			if(rest <= 0) {
				throw new TimeoutException("now - start = " + (now - start) + " ,timeout = " + timeout);
			}
			wait(rest);
		}
		doExecute();
	}
	
	private void doExecute() {
		System.out.println(Thread.currentThread().getName() + " calss doExecute()");
	}
}

public class Guarded_Timed{
	public static void main(String args[]) {
		Host host = new Host(10000);
		try {
			System.out.println("execute BEGIN");
			host.execute();
		}catch(TimeoutException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
