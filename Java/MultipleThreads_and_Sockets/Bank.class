class Bank{
	private int money;
	private String name;
	public Bank(int money, String name) {
		this.money = money;
		this.name = name;
	}
	
	/** "synchronized" is like a lock to prevent 
	 *  2 threads call the functions at the same time
	 * @param m
	 */
	public synchronized void deposit(int m) {
		money += m;
	}
	
	public synchronized boolean withdraw(int m) {
		if(money >= m) {
			money -= m;
			// withdraw successfully
			return true;
		}else {
			return false;
		}
	}
	
	public String getName() {
		return this.name;
	}
}
