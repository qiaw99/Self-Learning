# Log
1. TSLog(ThreadSpecificLog)

创建日志的类（实例属于各个线程所有）

每个线程会创建一个TSLog类的实例，所以需要将静态字段和静态方法修改为实例字段和实例方法

2. Log

创建日志的类

3. java.lang.ThreadLocal

分配线程特有的储存空间的类

4. ClientThread

表示调用Log的线程的类

5. Main

测试程序主类
