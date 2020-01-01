package Test;

@SuppressWarnings("hiding")
class HashTable<Integer, V>{
	int size;
	int counter;
	Slot<Integer, V>[] slots;
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.size = size;
		this.counter = 0;
		this.slots = new Slot[size];
	}
	
	public int getNumberOfElement() {
		return this.counter;
	}
	
	public void printHashTable() {
		for(int i = 0; i < size; i++) {
			if(slots[i] != null) {
				System.out.println(slots[i].value);
			}
		}
	}
	
	public int hash(Object key) {
		return (int)key % (size - 1);
	}
	
	public void insert(Slot<Integer, V> slot, Slot<Integer, V>[] slots) throws Exception {
		if(isFull()) {
			throw new Exception("The hashtable is full!");
		}else {
			int index = hash(slot.key);
			counter ++;
			
			while(slots[index] != null) {
				++ index;
				index %= size;
			}
			slots[index - 1] = slot;
		}	
	}
	
	public boolean isFull() {
		if(counter < size) {
			return false;
		}else {
			return true;
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
	public static void main(String[] args) {
		HashTable<Integer, String> hashTable = new HashTable<Integer, String>(5);
		System.out.println(hashTable.size);
		//System.out.println(hashTable.contain((Integer)5));
		try {
			hashTable.insert(new Slot<Integer, String>(2, "sth"), hashTable.slots);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		hashTable.printHashTable();
	}
}
