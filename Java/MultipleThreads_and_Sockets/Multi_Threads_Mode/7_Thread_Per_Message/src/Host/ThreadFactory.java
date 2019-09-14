import java.util.concurrent.ThreadFactory;

class Host{
	private final Helper helper = new Helper();
	private final ThreadFactory threadFactory;
	
	public Host(ThreadFactory threadFactory) {
		this.threadFactory = threadFactory;
	}

	public void request(final int count, final char c) {
		System.out.println("	request(" + count + ", " + c + ") BEGIN");
		threadFactory.newThread(
			new Runnable() {
				public void run() {
					helper.handle(count, c);
				}
			}
		).start();
		System.out.println("	request(" + count + ", " + c + ") END");
	} 
}

public class MAIN{
	public static void main(String args[]) {
		System.out.println("main BEGIN");
		Host host = new Host(
				new ThreadFactory() {
					public Thread newThread(Runnable r) {
						return new Thread(r);
					}
				}
		);
		host.request(10,'A');
		host.request(20,'B');
		host.request(30,'C');
		System.out.println("main END");
	}
}
