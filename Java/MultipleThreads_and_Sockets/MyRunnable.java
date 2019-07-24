package qiaw99;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	public void run(){
		
	}
	public static void main(String [] args) throws InterruptedException{
		ExecutorService es = Executors.newCachedThreadPool();
	}
}


