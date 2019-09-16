# java.util.concurrent.*
- java.util.concurrent.Callable接口
声明了call()，与Runnable接口的run()方法相似，只是call()有返回值。

Callable<String>则表示“Callable接口的call方法的返回值是String”

- java.util.concurrent.Future接口
声明了get()方法，但并没有声明设置值的方法。设置值的方法需要在实现Future接口的类中声明。Future<String>表示“Future接口get方法的返回值是String”

此外还有中断运行的cancel()方法

- java.util.concurrent.FutureTask类
实现了Future和Runnable。有获取值的get方法，中断运行的cancel方法，用于设置的set方法，以及用于设置异常的setException方法，run方法。
