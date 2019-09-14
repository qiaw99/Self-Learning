import java.util.concurrent.Executors;

// Use the code from ThreadFactory
public class Main{
	public static void main(String args[]) {
		System.out.println("main BEGIN");
		Host host = new Host(
				Executors.defaultThreadFactory()
				//获取当前默认设置的ThreadFactory对象
		);
		host.request(10,'A');
		host.request(20,'B');
		host.request(30,'C');
		System.out.println("main END");
	}
}
