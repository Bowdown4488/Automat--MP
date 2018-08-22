
public class Transition {

	private String input;
	private States state;
	
	public Transition(String input,States state) {
		this.input = input;
		this.state = state;
	}
	
	public String getInput() {
		return input;
	}
	public States getState() {
		return state;
	}

		
}
