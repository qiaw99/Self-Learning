import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**	
 * 在Executor.java中，使用Executor进行抽象化，但是最终还是需要自己手动执行 new Thread()，
 * 但是不一定每次都必须创建线程。
 * 
 * java.util.concurrent.ExecutorService接口对可以反复execute的服务进行了抽象化。
 * 线程一直在后台运行着，每当调用execute时，线程就会执行Runnable对象。因此需要shutdown方法来结束任务。
 * 
 * ExecutorService接口是Executor的子接口，所以接收Executor对象的Host类可以接收ExecutorService对象。
 * newCachedThreadPool() 创建可复用的线程型ExecutorServie对象，并用来创建Host对象。
 * 在对ExecutorService执行shutdown后，新的请求将不再被执行，这里使用的是Before/After模式
 * 
 * @author qiaw99
 */

public class MAIN{
	public static void main(String args[]) {
		System.out.println("main BEGIN");
		ExecutorService executorService = Executors.newCachedThreadPool();
		Host host = new Host(
				executorService
		);
		try {
			host.request(10,'A');
			host.request(20,'B');
			host.request(30,'C');
		}finally {
			executorService.shutdown();
			System.out.println("main END");
		}
	}
}
