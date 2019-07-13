import java.util.*;

interface Queue<T>{
	public void enqueue(T newElement);
	public T dequeue() throws EmptyQueueException;
	public boolean empty();
	public Iterator <T> iterator();
}

interface Iterator<T>{
	public boolean hasNext();
	public T next();
}

class EmptyQueueException extends Exception{
	public EmptyQueueException(String str){
		super(str);
	}
}

class ArrayQueue<T> implements Queue<T>{
	private int head;
	private int tail;
	private T [] queue;
	public ArrayQueue(int size){
		head=tail=0;
		queue=(T[]) new Object[size];
	}
	public boolean empty(){
		return head==tail;
	}
	public boolean full(){
		int size = queue.length;
		return (head==0&&tail==size-1)||(tail+1==head);
	}
	public void enqueue(T newElement){
		int size = queue.length;
		if(!full()){
			queue[tail]=newElement;
			if(tail==size-1)
				tail=0;
			else
				tail++;
		}else{
			queue=resize(queue);	
			queue[tail]=newElement;
			tail=size;	
		}
	}
	public T[] resize(T[] queue){
		int size = queue.length;
		T [] temp = (T []) new Object[2*size];
		for(int i=0;i<size;i++){
			temp[i]=queue[i];
		}
		return temp;
	}
	public T dequeue() throws EmptyQueueException{
		if(empty()){
			throw new EmptyQueueException("There is no element to dequeue!");
		}else{
			int size = queue.length;
			T temp = queue[head];
			queue[head]=null;
			if(head==size-1)
				head=0;
			else
				head++;
			return temp;
		}
	}
	public Iterator<T> iterator(){
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<T>{
		int current;
		public QueueIterator(){
			current=head;
		}
		public boolean hasNext(){
			return queue[current+1]!=null;
		}
		public T next(){
			T temp = queue[current+1];
			current++;
			return temp;
		}
	}
}

public class ArrayQueue{
	public static void main(String args[]){
		Number[]nums=new Integer[6];
		ArrayList<? extends Number> ls=new ArrayList<Double>(9);
		System.out.println("j");
	}
}
