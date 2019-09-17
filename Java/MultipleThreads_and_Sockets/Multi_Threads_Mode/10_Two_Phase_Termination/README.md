# Two Phase Termination 
1. java.long.Thread.join()
等待指定的线程终止

2. java.long.Thread.isAlive()
确认指定的线程是否终止

3. java.long.Thread.getState()
获取线程的状态

---
## ExecutorService interface
java.util.concurrent.ExecutorService接口可以隐藏背运行的线程，通过execute()方法执行Runnable对象类型的工作。

- 为了终止运行中的线程，可以使用shutdown()。isShutdown()方法用于却仍shutdown方法是否已经被调用。

- 即使isShutdown()返回true，也并不表示线程已经实际停止了。isTerminated()方法是用于确认线程是否已经停止了的方法。

        | isShutDown() |  isTerminated()      |
        |    false     |    false             |  操作中
        |    true      |    false             |  终止处理中
        |    true      |    true              |  终止

![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/Multi_Threads_Mode/10_Two_Phase_Termination/Interrupt.png)
