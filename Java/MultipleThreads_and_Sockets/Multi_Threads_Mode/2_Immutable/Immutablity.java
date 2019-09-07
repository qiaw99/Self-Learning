package test;

final class Person{
	private final String name;
	private final String address;
	
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String toString() {
		return "[ Person: name = " + this.name + " , address= " + this.address + " ]";
	}
}

class PrintPersonThread extends Thread{
	private Person person;
	
	public PrintPersonThread(Person person) {
		this.person = person;
	}
	
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName() + " prints" + this.person.toString());
		}
	}
}

public class Immutablity{
	public static void main(String args[]) {
		Person alice = new Person("Alice","Alaska");
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
	}
}
