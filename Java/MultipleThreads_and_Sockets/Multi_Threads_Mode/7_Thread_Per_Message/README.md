# Thread-Per-Message 
为了每个命令或者请求分配一个新的线程，由这个线程来进行处理。这种模式，能够提高与Client角色对应的Host角色的响应性，降低延迟时间。

在Host类中，使用匿名内部类的方法用到的参数或者是局部变量，必须声明为final，否则程序会出现编译错误。


+ 适用于操作顺序没有要求时：
handle方法不一定是按照request方法的调用顺序来执行的。所以，当操作要按照某种顺序执行时，此模式就不适用了

+ 适用于不需要返回值时：
request方法并不会等待handle方法执行结束。所以，request得不到handle的运行结果。如果需要的话可以使用Future模式。

+ 应用于服务器

![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/Multi_Threads_Mode/7_Thread_Per_Message/dict/request_and_handle.png)
