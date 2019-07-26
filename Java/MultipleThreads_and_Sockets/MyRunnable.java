package qiaw99;
import java.util.concurrent.*;


/** 线程池（Executors）--> java.util.concurrent.Executors类来创建线程池
 *  1. 创建固定大小的线程池：
 *  ExecutorService es = Executors.newFixedThreadPool(2);
 *  ->创建了一个20线程的线程池，当有新任务时，但是没有空闲线程可用，就进入队列等待。队列的上限是Integer.MAX_VALUE 
 *  优点：避免了线程创建和销毁的开销
 *  缺点：池大小的配置容易过高或者过低，会影响性能
 *  
 *  2.创建可变大小的线程池：
 *  ExecutorService es = Executors.newCachedThreadPool();
 *  ->创建了一个可缓存60秒的线程池。由新任务时，如果池中没有空闲线程可用，那么就会创建一个新线程并添加到池中，大小上限是Integer.MAX_VALUE
 *  优点：能按需创建线程，并且尽可能的回收或者复用
 *  缺点:池大小上限太大，当“洪峰”来临时容易在短时间内创建大量的线程
 *  
 *  3.创一个只有一个线程的线程池：
 *  ExecutorService es = Executors.newSingleThreadExecutor();
 *  <=>
 *  Executors.newFixedThreadPool(1);
 *  
 *  4.创建一个支持以固定周期或者固定时延执行定时任务的线程池
 *  ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
 */

public class MyRunnable implements Runnable {
	@Override
	public void run(){}
	public static void test(){
		//使线程能执行带返回值的任务
		ExecutorService es = Executors.newCachedThreadPool();
		/* 
		 *  Future和Callable类：
		 *  public interface Future<V> {
    			boolean cancel(boolean mayInterruptIfRunning);
    			boolean isCancelled();
    			boolean isDone();
    			V get() throws InterruptedException, ExecutionException;
    			V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
    			//指定时间内，如果还没获取到结果，直接返回null。
			}
			//接口类无法生成对象
			public class FutureTask<V> implements RunnableFuture<V>
			
			public interface RunnableFuture<V> extends Runnable, Future<V> {
    			void run();
			}
			
			Constructor:
			public FutureTask(Callable<V> callable) {}
			public FutureTask(Runnable runnable, V result) {}
			
			RunnableFuture继承了Runnable和Future接口，FutureTask实现了RunnableFuture接口，
			所以它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值
			
		 */
		Future<String> ft = es.submit(new Callable<String>(){
			public String call() throws Exception{
				Thread.sleep(1000);
				return "Hello World!";
			}
		});
		try{
			String s = ft.get();	//get方法获取执行结果，该方法会阻塞直到任务返回结果
			System.out.println(s);
		}catch(ExecutionException e){
			e.printStackTrace();
		}catch(InterruptedException a){
			a.printStackTrace();
		}
	}
	public static void main(String [] args) throws InterruptedException{
		ExecutorService es = Executors.newCachedThreadPool();
		//ExecutorService es = new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		/*
		 * int corePoolSize: 最小线程数
		 * int maximumPoolSize
		 * long keppAliveTime: 最大空闲时长
		 * TimeUnit unit: 空闲时长的时间单位， 默认是TimeUnit.MILLISECONDS
		 * BlockingQueue<Runnable> workQueue: 任务队列，不同类型的线程池采用不同类型的队列，
		 * 常用的有：SynchronousQueue, LinkedBlockingQueue, ArrayBlockingQueue.
		 * ThreadFactory threadFactory: 用于确定如何创建线程。一般用来决定线程是否为守护线程，并设置线程的分组，名称和优先级等属性。
		 * RejectedExecutionHandler handler:用于确定当线程的大小达到上限，无可用的空闲线程，且队列已经满了要如何处理。
		 */
		long l = System.currentTimeMillis();	//用来测试运行时间
		for(int i=0;i<5;i++){
			es.execute(new Runnable(){	//匿名内部类
				public void run(){
					int i = 0 ;
					//无论用shutdown还是shutdownNow去关闭线程池，此线程最终都会停止
					while(!Thread.interrupted() && i<Integer.MAX_VALUE){
						i++;
					}
				}
			});
		}
		es.shutdown();
		//es.shutdownNow();
		es.awaitTermination(10L,TimeUnit.SECONDS);
		System.out.println(System.currentTimeMillis()-1);
	}
}
/**
 * 通过Executors创建的线程池都实现了ExecutorService接口。调用execute()，submit()方法可以向线程池提交任务。
 * 1. shutdown()
 * 异步关闭线程池，调用后不允许再想线程池提交新任务，但允许继续执行已提交到线程池的任务
 * 2. shutdownNow()
 * 不继续执行已提交到线程池的任务
 * 3. awaitTermination(timeout,unit)
 * 调用此方法将阻塞当前线程，以等待线程池中的任务执行完毕。参数为最大的等待时间，需要在调用shutdown或者shutdownNow后使用
 * 4. isTerminated()
 * 判断在shutdown()后线程池中的任务是否完成
 * 5. execute()
 * 向线程池提交一个任务，不需要返回结果
 * 6. submit()
 * 需要返回结果
 * 7. isShutdown()
 * 返回线程池是否以及关闭
 * 8. invokeAll(tasks,timeout,unit)
 * 启动多个进程，并发执行多个任务，这些任务要么执行成功，要么因为异常或者超时而被取消
 * 9. invokeAny(tasks,timeout,unit)
 * 启动多个进程，相互独立计算一个结果，一旦其中一个返回成功，则终止其他线程
 */

