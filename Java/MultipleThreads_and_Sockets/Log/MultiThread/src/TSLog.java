package log;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TSLog {
	private PrintWriter writer = null;
	
	//��ʼ��writer�ֶ�
	public TSLog(String filename) {
		try {
			writer = new PrintWriter(new FileWriter(filename));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//д��־
	public void println(String s) {
		writer.println(s);
	}
	
	//�ر���־
	public void close() {
		writer.println("==== End of log ====");
		writer.close();
	}
}
