# Worker Thread:
> ClientThread: 表示发出工作请求的线程类
>> + 创建Request实例
>> + 将该实例传递给Channel类的putRequest()
---

> Request: 表示工作请求的类
>> name字段表示发送请求的委托者的名字，number字段表示请求的编号
---

> Channel： 接受工作请求并将工作请求交给工人线程的类
>> + putRequest()， takeRequest() ： 添加或者取出请求
>> + threadPool是WorkerThread的数组，数组大小由threads决定
---

> WorkerThread： 表示工人线程类
>> + 调用takeRequest()从Channel实例中获取一个Request实例
>> + 调用Request实例的execute()
---

![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/Multi_Threads_Mode/8_Worker_Thread/Worker.png)
