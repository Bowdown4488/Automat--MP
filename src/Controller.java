import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	private Game game;
	private ShortestSolution solution;
	
	public Controller(Machine machine) {
//		for(int i = 0 ; i < machine.getStates().size(); i++) {
//			System.out.println("State name: " + machine.getStates().get(i).getName());
//			System.out.println("State boolean: " + machine.getStates().get(i).getisFinal());
//			System.out.println("State position: " + machine.getStates().get(i).getPosition());
//			System.out.println("Number of Transitions: " + machine.getStates().get(i).getTransition().size());
//			for(int j = 0; j < machine.getStates().get(i).getTransition().size();j++) {
//				System.out.println("Transition #: " + j);
//				System.out.println("Transition Input: " + machine.getStates().get(i).getTransition().get(j).getInput());
//				System.out.println("Transition Name: " + machine.getStates().get(i).getTransition().get(j).getState().getName());
//			}
//			System.out.println("------------------------------------------------------------------------------------------------------");
//		}
		if(userChoice() == 1) {
			Game game = new Game(machine.getStates().get(0)); //First State
			gameItself(game);
		}
		else {
			solution = new ShortestSolution(machine);
		}
	}
	
	public int userChoice () {
		System.out.println("Game [1] or Solution [2] ?");
		Scanner input = new Scanner (System.in);
		int choice = input.nextInt();
		return choice;
	}
	
	public void gameItself (Game game) {
		Scanner sc = new Scanner(System.in);
		int moves = 0;
		boolean cont = true;
		String playerMove = "";
		ArrayList<String> visited = new ArrayList ();
		System.out.println("Legend: \n H - Human \n L - Lion \n C - Cow \n G - Grain \n Note: Enter by Hierarchy H->L->C->G");
		System.out.println("---------------------------------------------------------");
		while(cont != false) {
			System.out.println("Move # " + moves);
			System.out.println("Current State: " + game.getCurrState().getName() );
			System.out.println("Current Position: " + game.getCurrState().getPosition() );
			playerMove = sc.nextLine();
			System.out.println("Input Move: " + playerMove);
			States advance = game.checkTransition(playerMove);
			if(advance != null) {
				visited.add(advance.getName());
				System.out.print("States Visited: Q0 ");
				for(int j = 0; j < visited.size();j++) {
					System.out.print(" -> " + visited.get(j) );
				}
				moves++;
				if(advance.getisFinal() == true) {
					game = new Game(advance);
					System.out.println("\nLast state has been reached");
					System.out.println("Number of moves to finish: " + moves);
					System.out.println("Last Position: " + game.getCurrState().getPosition() );
					cont = false;
				}
				else {
					System.out.println("\nChanging to state: " + advance.getName());
					game = new Game(advance);
					System.out.println("---------------------------------------------------------");
				}
			}
			else {
				System.out.println("Game Over");
				cont = false;
			}
		}
	}
	
}
