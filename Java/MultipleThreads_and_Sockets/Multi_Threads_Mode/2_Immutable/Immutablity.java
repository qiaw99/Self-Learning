package test;

/*
 * "Immutable Mode"
 * Java.lang.String表示字符串，但是在类中并没有修改字符串的方法，
 * 也就说，String的实例所表示的内容不会发生变化
 */

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
