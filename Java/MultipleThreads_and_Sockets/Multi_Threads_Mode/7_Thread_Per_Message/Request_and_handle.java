package test;

class Host{
	private final Helper helper = new Helper();

	public void request(final int count, final char c) {
		System.out.println("	request(" + count + ", " + c + ") BEGIN");
		new Thread() {
			public void run() {
				helper.handle(count,c);
			}
		}.start();
		System.out.println("	request(" + count + ", " + c + ") END");
	} 
}

class Helper{
	public  void handle(int count, char c) {
		System.out.println("	handle(" + count + ", " + c + ") BEGIN");
		for(int i = 0; i < count; i++) {
			slowly();
			System.out.print(c);
		}
		System.out.println("");
		System.out.println("	handle(" + count + ", " + c + ") END");
	}
	
	private void slowly() {
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Request_and_handle{
	public static void main(String args[]) {
		System.out.println("main BEGIN");
		Host host = new Host();
		host.request(10,'A');
		host.request(20,'B');
		host.request(30,'C');
		System.out.println("main END");
	}
}
