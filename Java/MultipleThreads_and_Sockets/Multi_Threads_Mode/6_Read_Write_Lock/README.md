# Read-Write Lock

      |         read           |               write                    |
     
      |       no conflict      |         read-write conflict            |  read

      |   read-write conflict  |         write-write conflict           |  write

---
## java.util.concurrent.locks
>ReadWriteLock interface

+ readLock()        -> readLock().lock()

+ readUnlock()      -> readLock().unlock()

+ writeLock()       -> writeLock().lock()

+ writeUnlock()     -> writeLock().unlock()

>ReentrantReadWriteLock class
- 公平性：
__在创建ReentrantReadWriteLock类实例的时候，可以选择锁的获取顺序是否设置为fair的，如果是fair的，那么等待时间久的线程可以优先获得锁。__

- 可重入性:
__ReentrantReadWriteLock类的锁是可重入的(Reentrant)。也就是说，Reader线程可以获得“用于写入的锁”，Writer线程可以获得“用于读取的锁”。__

# _*Result*_

![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/Multi_Threads_Mode/6_Read_Write_Lock/result.png)
