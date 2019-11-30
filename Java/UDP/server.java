import java.io.*;
import java.net.*;

public class server{
	public static void main(String args[]) throws Exception{
		DatagramSocket server_socket = new DatagramSocket(1234);
		BufferedReader server_input = new BufferedReader(new InputStreamReader(System.in));
		InetAddress IP_add = InetAddress.getByName("localhost");
		byte out_data[] = new byte[1024];
		byte in_data[] = new byte[1024];
		while(true){
			DatagramPacket Packet2 = new DatagramPacket(in_data, in_data.length);
			server_socket.receive(Packet2);
			String Str = new String(Packet2.getData());
			System.out.println(Str);

			InetAddress IP_add1 = Packet2.getAddress();
			int port = Packet2.getPort();
			String send_str = server_input.readLine();
			out_data = send_str.getBytes();
			DatagramPacket Packet3 = new DatagramPacket(out_data, out_data.length, IP_add1, port);
			server_socket.send(Packet3);
		}
	}
}
