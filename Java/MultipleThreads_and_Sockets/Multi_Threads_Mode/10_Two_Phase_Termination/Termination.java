package test;

class CounterupThread extends Thread {
	private long counter = 0;
	private volatile boolean shutdownRequested = false;
	
	public void shutdownRequest() {
		shutdownRequested = true;
		interrupt();
	}
	
	public boolean isShutdownRequested() {
		return shutdownRequested;
	}
	
	public final void run() {
		try {
			while(!isShutdownRequested()) {
				doWork();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			doShutdown();
		}
	}
	
	private void doWork() throws InterruptedException{
		counter++;
		System.out.println("doWork: counter = " + counter);
		Thread.sleep(500);
	}
	
	private void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);
	}	
}

public class Termination{
	public static void main(String args[]) {
		System.out.println("main: BEGIN");
		try {
			// start the new thread
			CounterupThread t = new CounterupThread();
			t.start();
			
			// sleep for a while
			Thread.sleep(10000);
			
			//request to shut down
			System.out.println("main shutdownRequest");
			t.shutdownRequest();
			
			// wait until the thread is terminated
			System.out.println("main: join");
			t.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("main: END");
	}
}
