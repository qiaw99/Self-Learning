# Read-Write Lock

      |         read           |               write                    |
     
      |       no conflict      |         read-write conflict            |  read

      |   read-write conflict  |         write-write conflict           |  write

---
## java.util.concurrent.locks
>提供了ReadWriteLock interface, ReentrantReadWriteLock class.

+ readLock()        -> readLock().lock()

+ readUnlock()      -> readLock().unlock()

+ writeLock()       -> writeLock().lock()

+ writeUnlock()     -> writeLock().unlock()
# _*Result*_

![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/Multi_Threads_Mode/6_Read_Write_Lock/result.png)
