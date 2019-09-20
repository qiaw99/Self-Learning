package active_object;

public class ActiveObjectFactory {
	public static ActiveObject createActiveObject() {
		/**
		 * Servant:	ִ��ʵ�ʴ�����ࣨʵ��ActiveObject�ӿڣ�
		 * ActivationQueue:	��˳�򱣴�MethodeRequest�������
		 * SchedulerThread:	����execute��������MethodeRequest�������
		 * Proxy:  ����������ת��ΪMethodeRequest�����ࣨʵ��ObjectActive�ӿڣ�
		 */
		Servant servant = new Servant();
		ActivationQueue queue = new ActivationQueue();
		SchedulerThread scheduler = new SchedulerThread(queue);
		Proxy proxy = new Proxy(scheduler, servant);
		scheduler.start();
		return proxy;
	}
}
