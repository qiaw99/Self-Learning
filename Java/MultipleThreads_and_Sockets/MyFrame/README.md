# javax.swing.SwingUtilities类
1. static void invokeAndWait(Runnable runnable) throws InterruptedException, InvocationTargetException;

事件分发线程会调用runnable.run()。只有当时间内队列中的所有事件都被处理完毕，runnable.run()的执行结束后，控制权才会从invokeAndWait()返回

2. static void invokeLater(Runnable runnable);

调用该方法后，控制权会立即返回

3. static boolean isEventDispatchThread();

如果当前线程是事件分发线程就返回true

---
### Swing的单线程规则:
The single-thread rule:

一旦Swing的组件被实现了，那么改变组件状态的代码和依赖组件状态的代码就必须由事件分发线程执行

---
![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/MyFrame/MyFrame.png)
