package test;

interface Data{
	public abstract String getContent();
}

class Host{
	public Data request(final int count, final char c) {
		System.out.println("	request(" + count + ", " + c + ") BEGIN");
		
		//创建FutureData实例
		final FutureData future = new FutureData();
		
		//启动一个新线程，用于创建RealData的实例
		new Thread() {
			public void run() {
				RealData realdata = new RealData(count, c);
				future.setRealData(realdata);
			}
		}.start();
		
		System.out.println("	request(" + count + ", " + c + ") END");
		
		//返回FutureData实例
		return future;
	}
}

class FutureData implements Data{
	private RealData realdata = null;
	private boolean ready = false;
	
	public synchronized void setRealData(RealData realdata) {
		if(ready) {
			return;
		}
		this.realdata = realdata;
		this.ready = true;
		notifyAll();
	}
	
	public synchronized String getContent() {
		while(!ready) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realdata.getContent();
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

public class Future{
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
