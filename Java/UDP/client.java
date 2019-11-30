import java.io.*;
import java.net.*;

public class client{
	public static void main(String[] args) throws Exception{
		BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket client_socket = new DatagramSocket();
		InetAddress IP_add = InetAddress.getByName("localhost");
		byte in_data[] = new byte[1024];
		byte out_data[] = new byte[1024];
		String Str = user_input.readLine();
		out_data = Str.getBytes();
		DatagramPacket Packet1 = new DatagramPacket(out_data, out_data.length, IP_add, 1234);
		client_socket.send(Packet1);
		DatagramPacket Packet4 = new DatagramPacket(in_data, in_data.length, IP_add, 1234);
		client_socket.receive(Packet4);
		String receive_str = new String(Packet4.getData());
		System.out.println(receive_str);
		client_socket.close();
	}
}
