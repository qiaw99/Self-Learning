# Guarded Timed
### (1) 想要使用synchronized获取锁但处于Block状态
(1)状态下的线程无法发生超时，synchronized方法和代码块都无法设置超时时间
即使(1)状态下的线程执行interrupt也不会抛出InterruptedException。
线程必须在获取锁并且进入synchronized之后，调用wait，sleep，join等等才会抛出。

### (2) 执行wait()并进入wait队列
(2)J2SE 6.0的java.util.concurrent中提供了两个用于超时处理的方法

###### 1)通过异常通知超时
当发生超时抛出异常时，返回值并不适合用于表示异常，需要用java.util.concurrent.TimeoutException

1. java.util.concurrent.Future            -> interface: get()

2. java.util.concurrent.Exchanger         -> class: exchange()

3. java.util.concurrent.Cyclicarrier      -> class: await()

4. java.util.concurrent.CountDownLatch    -> class: await()    

###### 2)通过返回值通知超时
当执行多次try时，则不使用异常，而是用返回值来表示超时

1. java.util.concurrent.BlockingQueue      ->interface 

-> offer()   false
-> poll()    null

2. java.util.concurrent.Semaphore          ->class

-> tryAcquire() false

3. java.util.concurrent.locks.lock         ->interface

-> tryLock()  false
