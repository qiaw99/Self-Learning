package qiaw99;
/**
 * 一个Java进程至少有一个线程（主线程），对应到代码就是main方法所在的线程。
 * 线程分为：用户线程，守护线程。两者区别在于，后者会随着主线程结束而结束。
 * 
 * 通过继承Thread类，覆盖其run（）方法就可编写一个线程类。
 *
 */
class MyThread extends Thread{
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			try{
				Thread.sleep(10L);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

public class Threads_and_Methodes{
	public static void main(String args[]){
		Thread t = new MyThread();		//upcasting
		/*
		 * 调用start()方法后，run（）方法中的代码并不一定会
		 * 立即执行。start（）方法只是将线程变为runnable状态，
		 * 什么时候运行是由操作系统决定。
		 */
		t.start();
		t.run();
		System.out.println("ok");
	}
}

/*
1. t.start();
//启动线程t，将状态从new转换为runnable
2. t.checkAccess(); 
//检查当前线程是否有权限访问线程t
3. t.interrupt();
4. t.setPriority(8);
5. t.isDaemon();
//判断线程t是否为守护线程，当进程中仅剩守护线程时JVM将退出。
6. t.setDaemon(true);
//仅用于在调用start（）前设置线程t是否为守护线程
7. t.isInterrupted();
//用于检查是否被要求中断。当此方法返回true的时，当前线程应该判断是否要中断执行，
//如果此时不中断执行再次调用此方法时就会返回false
8. t.isAlive();
9. t.join(1000L);
//当前线程等待线程t终止。参数为超时时间
10. t.setName("thread_name_1");
11. Thread.yield();
//让当前线程让出CPU，并转为runnable，重新参与CPU使用权的竞争。
//只有优先级大于或等于当前线程的进程的线程才有可能获得CPU的使用权
12. Thread.sleep(100L);
//让当前线程让出CPU，睡眠（阻塞）100毫秒，然后回到runnable
13. Thread.currentThread();
//得到当前线程对象的引用
 */

/**
 * wait()和sleep()的区别：
 * 虽然二者都可以让程序阻塞指定的毫秒数，并且都可以通过interrupt()来打断，
 * wait()是Object方法，必须在synchronized同步块或方法中使用；
 * wait()方法会释放由synchronized锁上的对象锁，而sleep()不会；
 * 由wait()引发的阻塞，可以通过针对同一个对象锁的synchronized作用域调用notify()/notifyAll()来唤醒，
 * 而sleep()则无法被唤醒，只能定时醒来或者被interrupt()
 */

/**
 * sleep和yield区别：
 * 线程执行sleep()后转为blocked，并在睡眠一段时间后自动转为runnable，而执行yield()后，当前线程转入的是runnable；
 * sleep()执行后，其他的线程无论优先级高低，都有机会执行，但是yield()只会给具有相同优先级或者跟高优先级的线程；
 * sleep()方法需要声明抛出InterruptedException，而yield()不需要；
 * sleep()由更好的移植性(portable)
 */

