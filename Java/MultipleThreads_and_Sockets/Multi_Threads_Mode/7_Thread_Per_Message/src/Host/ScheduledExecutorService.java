import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**	
 * java.util.concurrent.ScheduledExecutorService接口是ExecutorService的子接口，用于推迟操作的执行。
 * schedule(Runnable r, long delay, TimeUnit unit);
 * 
 * unit: NANOSECONDS, MICROSECONDS, MILLTSECONDS, SECONDS
 * 
 * Executors.newScheduledThreadPool()会创建可复用线程型ScheduledExecutorService对象，
 * 并且使用该对象来创建Host类对象。参数中的5表示无工作时也会一直持有的线程个数
 * 
 * @author qiaw99
 */

class Host{
	private final Helper helper = new Helper();
	private final ScheduledExecutorService scheduledExecutorService;
	
	public Host(ScheduledExecutorService scheduledExecutorService) {
		this.scheduledExecutorService = scheduledExecutorService;
	}

	public void request(final int count, final char c) {
		System.out.println("	request(" + count + ", " + c + ") BEGIN");
		scheduledExecutorService.schedule(
			new Runnable() {
				public void run() {
					helper.handle(count, c);
				}
			},
			3L,
			TimeUnit.SECONDS
		);
		System.out.println("	request(" + count + ", " + c + ") END");
	} 
}

public class MAIN{
	public static void main(String args[]) {
		System.out.println("main BEGIN");
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
		Host host = new Host(
				scheduledExecutorService
		);
		try {
			host.request(10,'A');
			host.request(20,'B');
			host.request(30,'C');
		}finally {
			scheduledExecutorService.shutdown();
			System.out.println("main END");
		}
	}
}
