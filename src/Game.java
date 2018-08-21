import java.util.ArrayList;

public class Game {
	private States currState;
	
	public Game(States currState) {
		this.currState = currState;
	}
	
	public States getCurrState() {
		return currState;
	}
	
	public States checkTransition(String move){
	int i = 0;
	boolean isEqual = false;
	while(i < currState.getTransition().size() && isEqual!= true) {
		if(move.equals(currState.getTransition().get(i).getInput())) {
			isEqual = true;
			return currState.getTransition().get(i).getState();
		}
		i++;
	}
	return null;
	}
}
