# Future 
- Host
向请求返回FutureData的实例的类

- Data
表示访问数据的方法的接口。由FutureData和RealData实现接口

- FutureData
表示RealDatade "提货单"的类。其他线程会创建RealData的实例

-RealData
表示实际数据的类。构造函数的处理会花费大量时间。
