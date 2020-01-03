package Test;

@SuppressWarnings("hiding")
class HashTable<Integer, V>{
	int size;
	int counter;
	Slot<Integer, V>[] slots;
	boolean deleted[];
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.size = size;
		this.counter = 0;
		this.slots = new Slot[size];
		this.deleted = new boolean[this.size];
		initialize();
	}
	
	private int hash(Object key) {
		return (int)key % size;
	}
	
	public int getNumberOfElement() {
		return this.counter;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	private boolean isFull() {
		if(counter < size) {
			return false;
		}else {
			return true;
		}
	}
	
	private void initialize() {
		for(int i = 0; i < this.size; i++) {
			this.deleted[i] = true;
		}
	}
	
	public void printDeleted() {
		for(int i = 0; i < this.size; i++) {
			System.out.println(this.deleted[i]);
		}
	}
	
	public void printHashTable() {
		for(int i = 0; i < size; i++) {
			if(slots[i] != null) {
				System.out.println("The value = " + slots[i].value + ", the index = " + i + ", deleted = " + deleted[i]);
			}
		}
	}
	
	public void delete(int key) throws Exception{
		if(isEmpty()) {
			throw new Exception("The hashtable is empty!");
		}else if(key > this.size - 1 || key < 0) {
			throw new IndexOutOfBoundsException();
		}else {
			deleted[key] = true;
		}
	}
	
	public int search(int key) {
		int j;
		int i = 0;

		while(i != this.size || slots[i] != null) {
			j = hash(key);
			if(slots[j].key.equals(key) && deleted[j] == false) {
				return j;
			}
		}
		
		// -1 means error
		return -1;
	}
	
	public void insert(Slot<Integer, V> slot, Slot<Integer, V>[] slots) throws Exception {
		if(isFull()) {
			throw new Exception("The hashtable is full!");
		}else {
			int index = hash(slot.key);
			counter ++;
			while(deleted[index] != true) {
				if(++ index > size - 1) {
					index = 0;
				}
			}
			
			slots[index] = slot;
			deleted[index] = false;
		}	
	}
	
	public boolean contain(Integer key) {
		int i = hash(key);
		while(i < this.size) {
			if((slots[i].key).equals(key)) {
				return true;
			}else {
				i += 1;
			}
		}
		return false;
	}
}

@SuppressWarnings("hiding")
class Slot<Integer, V>{
	Integer key;
	V value;
	
	public Slot(Integer key, V value) {
		this.key = key;
		this.value = value;
	}
}

public class HashTabelle {
	public static void main(String[] args){
		HashTable<Integer, String> hashTable = new HashTable<Integer, String>(5);
		
		try {
			hashTable.insert(new Slot<Integer, String>(3, "sth"), hashTable.slots);
			hashTable.insert(new Slot<Integer, String>(1, "sth1"), hashTable.slots);
			hashTable.insert(new Slot<Integer, String>(2, "sth2"), hashTable.slots);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			hashTable.delete(2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		hashTable.printHashTable();
	}
}
