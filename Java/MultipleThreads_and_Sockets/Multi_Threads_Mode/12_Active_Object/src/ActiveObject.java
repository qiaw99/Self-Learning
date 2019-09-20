package active_object;

public interface ActiveObject {
	public abstract Result<String> makeString(int count, char fillchar);
	public abstract void displayString(String string);
}
