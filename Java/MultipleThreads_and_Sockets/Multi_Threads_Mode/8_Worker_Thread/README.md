# Worker Thread:
> ClientThread: 表示发出工作请求的线程类
>> + 创建Request实例
>> + 将该实例传递给Channel类的putRequest()

+ Request: 表示工作请求的类

+ Channel： 接受工作请求并将工作请求交给工人线程的类

+ WorkerThread： 表示工人线程类
