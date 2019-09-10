# Guarded Timed
### (1) 想要使用synchronized获取锁但处于Block状态
(1)状态下的线程无法发生超时，synchronized方法和代码块都无法设置超时时间
即使(1)状态下的线程执行interrupt也不会抛出InterruptedException。
线程必须在获取锁并且进入synchronized之后，调用wait，sleep，join等等才会抛出。

# (2) 执行wait()并进入wait队列
(2)
