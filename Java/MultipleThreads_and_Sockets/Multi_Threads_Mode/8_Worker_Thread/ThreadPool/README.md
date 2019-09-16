# Worker Thread mode implemented by java.util.concurrent.*
__java.util.concurrent.ThreadPoolExecutor类是管理工人线程的类__

+ Executor.newFixedThreadPool()
创建一个线程池，该线程池创建个数由参数指定的线程，而且创建出的线程会被重复利用。

+ Executor.newCachedThreadPool()
创建一个线程池，该线程池可以根据需要自动创建工人线程池，而且创建的工人线程会被重复利用。没有工作的工人线程会在缓存60s后自动终止

+ Executor.newScheduledThreadPool()
创建一个线程池，该线程池可以一直一定时间后执行请求或是反复执行请求。即使没有请求时也需要保存的线程数量可以通过参数指定。

ClientThread类是通过java.util.concurrent.ExecutorService接口使用线程池。当ExecutorService进入终止处理后，execute()方法就会被拒绝(reject)执行，并且抛出RejectedExecutionException

![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/Multi_Threads_Mode/8_Worker_Thread/ThreadPool/ThreadPool.png)
