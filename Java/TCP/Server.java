package networkprogramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]) {
		try {
			Thread thread = new GreetingServer(8080);
			thread.run();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

class GreetingServer extends Thread{
	private ServerSocket serverSocket;
	
	public GreetingServer(int port) throws IOException{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("Waiting for remote connecting... Port is: " + serverSocket.getLocalPort());
				Socket server = this.serverSocket.accept();
				System.out.println("The remote Adress: " + server.getRemoteSocketAddress());
				System.out.println(new DataInputStream(server.getInputStream()).readUTF());
				new DataOutputStream(server.getOutputStream()).writeUTF("Thanks for connecting me: " + server.getLocalSocketAddress());
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
