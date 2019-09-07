package test;

class Gate{
	private int counter;
	private String name;
	private String address;
	
	public Gate() {
		this.counter = 0;
		this.name = "Nobody";
		this.address = "Nowhere";
	}
	
	//thread-safe
	public synchronized void pass(String name, String address) {
		this.counter++;
		this.name = name;
		this.address = address;
		check();
	}
	
	public synchronized String toString() {
		return "No." + this.counter + ": " + this.name + ", " + this.address;
	}
	
	public void check() {
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("*****BROKEN*****"+toString());
		}
	}
}

class UserThread extends Thread{
	private final Gate gate;
	private final String myname;
	private final String myaddress;
	
	public UserThread(Gate gate, String myname, String myaddress) {
		this.gate = gate;
		this.myname =myname;
		this.myaddress = myaddress;
	}
	
	public void run() {
		System.out.println(myname + " BEGIN");
		while(true) {
			gate.pass(myname,myaddress);
		}
	}
}

public class Through_a_single_door{
	public static void main(String args[]) {
		System.out.println("Testing Gate, hit CTRL+C to exit.");
		Gate gate = new Gate();
		new UserThread(gate,"Alice","Alaska").start();
		new UserThread(gate,"Bobby","Brazil").start();
		new UserThread(gate,"Chris","Canada").start();
	}
}
