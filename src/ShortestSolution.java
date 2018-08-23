import java.util.ArrayList;

public class ShortestSolution {

	private Machine machine;
	ArrayList<ArrayList<States>> visitedStates; //states already visited
	ArrayList<ArrayList<String>> solutionInputs; //input of solutions
	ArrayList<ArrayList<States>> lowestVisitedStates; //states with the shortest path
	ArrayList<ArrayList<String>> lowestSolutionInputs; //inputs of the shortest paths solutions
	
	public ShortestSolution(Machine machine){
		this.machine = machine;
		visitedStates = new ArrayList<>();
		solutionInputs = new ArrayList<>();
		lowestVisitedStates = new ArrayList<>();
		lowestSolutionInputs = new ArrayList<>();
		ArrayList<States> visited = new ArrayList<>(); //array list of visited states
		ArrayList<String> solutions = new ArrayList<>(); //array list of solutions
		States start = machine.getStates().get(0); //First State
		visited.add(start); //adding the first state to the visited
		getSolution(start,visited,solutions); //recursive function to check all states
		int shortestPath = solutionInputs.get(0).size();
		for(int i = 1 ; i < solutionInputs.size() ; i++) { //starts at the next solutionInput size
			if(shortestPath > solutionInputs.get(i).size()) {
				shortestPath = solutionInputs.get(i).size(); //like a min function that changes the min everytime it sees a lower path solution
			}
		}
		for(int i = 0 ; i < solutionInputs.size() ; i++) {
			if(shortestPath == solutionInputs.get(i).size()) {
				lowestVisitedStates.add(visitedStates.get(i));
				lowestSolutionInputs.add(solutionInputs.get(i));//saves the solution string of those with the shortest path
			}
		}
		
		//Testing Prints will remove later
		//Same values in the array list so it is separated for now
		System.out.println("Shortest path Solution count is " + shortestPath);
		System.out.println(lowestSolutionInputs.get(0));
		System.out.println(lowestSolutionInputs.get(1));
		System.out.println(lowestSolutionInputs.get(2));
		System.out.println(lowestSolutionInputs.get(8));
		
		System.out.println("\nTotal Number of Solutions:" + solutionInputs.size());
		for(int i = 0; i < solutionInputs.size(); i++)
		{
			System.out.println(solutionInputs.get(i));
		}
		
//		ArrayList<ArrayList<String>> notPurged = new ArrayList<>(); 
//		for(int i = 0; i < lowestSolutionInputs.size(); i++)
//		{
//			int j = i;
//			int next = 0;
//			System.out.println(lowestSolutionInputs.get(i));
//			while(j < lowestSolutionInputs.size()-1 && next == 0) {
//				if(!lowestSolutionInputs.get(i).equals(lowestSolutionInputs.get(j+1)) ) {
//					notPurged.add(lowestSolutionInputs.get(i));
//					next = 1;
//				}
//				j++;
//			}
//		}
//		System.out.println("END LOOP");
//		
//		for(int i = 0;i < notPurged.size(); i++) {
//			System.out.println(notPurged.get(i));
//		}
	}
	
	public void getSolution(States state, ArrayList<States> visited, ArrayList<String> solution ) {
		if(!state.getisFinal()) {
			for(int i = 0 ; i < state.getTransition().size() ; i++) {
				States freshState = state.getTransition().get(i).getState(); //gets the new state in the list of states
				if(!visited.contains(freshState)) {
					visited.add(freshState); //adds the state to the visited states
					solution.add(state.getTransition().get(i).getInput()); //adds the name of the state base on its transition
					getSolution(freshState, visited, solution); //calls the recursive function to solve for the next node
					visited.remove(visited.size()-1);
					solution.remove(solution.size()-1);
				}
			}
		}else {
			ArrayList<States> newComer = new ArrayList<>(); //newstate visited
			ArrayList<String> newSolve = 	new ArrayList<>(); //new path solution
			newComer.addAll(visited); //adds all the visited states
			newSolve.addAll(solution); //adds all the solutions found
			funcVisited(newComer); //adds the new state to the visited states list
			funcAddInputs(newSolve); //adds the new solution to the list of solutions
		}
	}
	
	public ArrayList<ArrayList<String>> getLowestSolutions () {
		return lowestSolutionInputs;
	}
	
	public ArrayList<ArrayList<String>> getSolution () {
		return solutionInputs;
	}
	
	public void funcAddInputs(ArrayList<String> solution) {
		this.solutionInputs.add(solution);
	}
	
	public void funcVisited(ArrayList<States> visited) {
		this.visitedStates.add(visited);
	}
		
}
