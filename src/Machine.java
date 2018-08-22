import java.util.ArrayList;

public class Machine {
	
private ArrayList<States> states;
	
	public Machine() {
		states = new ArrayList<>();	
	}
	
	public void addMachine(States state) {
		states.add(state);
	}



	public ArrayList<States> getStates() {
		return states;
	}
	
	
}
