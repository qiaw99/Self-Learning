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


public class Day1{
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
