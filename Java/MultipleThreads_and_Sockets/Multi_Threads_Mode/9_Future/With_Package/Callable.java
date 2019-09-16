package test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutionException;

interface Data{
	public abstract String getContent();
}

class Host{
	public Data request(final int count, final char c) {
		System.out.println("	request(" + count + ", " + c + ") BEGIN");
		
		FutureData future = new FutureData(
			new Callable<RealData>() {
				public RealData call() {
					return new RealData(count, c);
				}
			}
		);
		
		new Thread(future).start();
		
		System.out.println("	request(" + count + ", " + c + ") END");
		
		return future;
	}
}

class FutureData extends FutureTask<RealData> implements Data{
	public FutureData(Callable <RealData> callable) {
		super(callable);
	}
	
	public String getContent() {
		String string = null;
		try {
			string = get().getContent();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(ExecutionException e) {
			e.printStackTrace();
		}
		return string;
	}
}

class RealData implements Data{
	private final String content;
	
	public RealData(int count, char c) {
		System.out.println("	making RealData(" + count + ", " + c + ") BEGIN");
		char buffer[] = new char[count];
		for(int i = 0; i < count; i++) {
			buffer[i] = c;
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("	making RealData(" + count + ", " + c + ") END");
		this.content = new String(buffer);
	}
	
	public String getContent() {
		return content;
	}
}

public class Callable{
	public static void main(String args[]) {
		System.out.println("main BEGIN");
		Host host = new Host();
		Data data1 = host.request(10,'A');
		Data data2 = host.request(20,'B');
		Data data3 = host.request(30,'C');
		
		System.out.println("main otherJob BEGIN");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main otherJob END");
		
		System.out.println("data1 = " + data1.getContent());
		System.out.println("data2 = " + data2.getContent());
		System.out.println("data3 = " + data3.getContent());
	}
}
