假设程序抛出异常时，并没有编写异常的catch模块，这时会导致程序在输出线程的调用堆栈信息后终止。

使用Thread类的setDefaultUncaughtExceptionHandler静态方法，可以设置为捕获的异常的处理器(Uncaught Exception Handler)

![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/Multi_Threads_Mode/10_Two_Phase_Termination/Handle_Exception/Handle.png)
