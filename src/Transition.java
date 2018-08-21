
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
	public void setInput(String input) {
		this.input = input;
	}
	public States getState() {
		return state;
	}
	public void setState(States state) {
		this.state = state;
	}
	
	
}
