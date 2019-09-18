package log;

public class Log {
	//tsLogCollection保存着各个线程的TSLog的实例
	private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();
	
	public static void println(String s) {
		getTSLog().println(s);
	}
	
	public static void close() {
		getTSLog().close();
	}
	
	private static TSLog getTSLog() {
		TSLog tsLog = tsLogCollection.get();
		
		if(tsLog == null) {
			tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
			tsLogCollection.set(tsLog);
		}
		return tsLog;
	}
}
