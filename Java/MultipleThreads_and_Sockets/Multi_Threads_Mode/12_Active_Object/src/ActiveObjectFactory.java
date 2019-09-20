package active_object;

public class ActiveObjectFactory {
	public static ActiveObject createActiveObject() {
		/**
		 * Servant:	执行实际处理的类（实现ActiveObject接口）
		 * ActivationQueue:	按顺序保存MethodeRequest对象的类
		 * SchedulerThread:	调用execute方法处理MethodeRequest对象的类
		 * Proxy:  将方法调用转换为MethodeRequest对象类（实现ObjectActive接口）
		 */
		Servant servant = new Servant();
		ActivationQueue queue = new ActivationQueue();
		SchedulerThread scheduler = new SchedulerThread(queue);
		Proxy proxy = new Proxy(scheduler, servant);
		scheduler.start();
		return proxy;
	}
}
