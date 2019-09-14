import java.util.concurrent.Executor;

/**
 * java.util.concurrent.Executor接口声明：
 * void execute(Runnable r);
 * 可以隐藏创建线程的操作。 
 * 
 * Host类如何执行Runnable对象，取决于构造函数中传入的Executor对象
 * @author qiaw99
 *
 */

public class Host{
	private final Helper helper = new Helper();
	private final Executor executor;
	
	public Host(Executor executor) {
		this.executor = executor;
	}

	public void request(final int count, final char c) {
		System.out.println("	request(" + count + ", " + c + ") BEGIN");
		executor.execute(
			new Runnable() {
				public void run() {
					helper.handle(count, c);
				}
			}
		);
		System.out.println("	request(" + count + ", " + c + ") END");
	} 
}
