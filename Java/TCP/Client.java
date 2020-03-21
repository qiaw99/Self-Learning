package networkprogramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String args[]) {
		try {
			Socket clientSocket = new Socket("localhost", 8080);
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
			
			out.writeUTF("Hello From " + clientSocket.getLocalSocketAddress());
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			System.out.println("Server response: " + in.readUTF());
			clientSocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
