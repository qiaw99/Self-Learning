package active_object;

class DisplayStringRequest extends MethodRequest<String>{
	private final String string;
	
	public DisplayStringRequest(Servant servant, String string) {
		super(servant, null);
		this.string = string;
	}
	
	public void execute() {
		servant.displayString(string);
	}
}
