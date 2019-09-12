# Database
Implements database with HashMap.

+ clear(): 全部清除

+ assign(K key, V value): 给key分陪value

+ retrieve(K key):获取给key分配的值

__在RetrieveThread类中定义了一个atomicCounter静态字段，用来计算retrieve方法的调用次数。该字段是

java.util.concurrent.atomic.AtomicInteger类的实例，可以使用incrementAndGet()方法原子递增1;__
