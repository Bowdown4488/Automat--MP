import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//States
		States Q0 = new States("Q0",false,"Earth:(S) HHLCG | Mars: - ");
		States Q1 = new States("Q1",false,"Earth: HHG | Mars: (S) LC ");
		States Q2 = new States("Q2",false,"Earth: (S) HHLG | Mars: C ");
		States Q3 = new States("Q3",false,"Earth: HH | Mars: (S) LCG ");
		States Q4 = new States("Q4",false,"Earth: (S) HHC | Mars: LG ");
		States Q5 = new States("Q5",false,"Earth: C | Mars: (S) HHLG ");
		States Q6 = new States("Q6",false,"Earth: (S) CL | Mars: HHG ");
		States Q7 = new States("Q7",true,"Earth: - | Mars: (S) HHLCG ");
		States Q8 = new States("Q8",false,"Earth: (S) HHCG | Mars: L ");
		States Q9 = new States("Q9",false,"Earth: HG | Mars: (S) HLC ");
		States Q10 = new States("Q10",false,"Earth: (S) HLCG | Mars: H ");
		States Q11 = new States("Q11",false,"Earth: LG | Mars: (S) HHC ");
		States Q12 = new States("Q12",false,"Earth: (S) LCG | Mars: HH ");
		States Q13 = new States("Q13",false,"Earth: L | Mars: (S) HHCG ");
		States Q14 = new States("Q14",false,"Earth: (S) HLC | Mars: HG ");
		States Q15 = new States("Q15",false,"Earth: H | Mars: (S) HLCG ");
		States Q16 = new States("Q16",false,"Earth: (S) HHLC | Mars: G ");
		States Q17 = new States("Q17",false,"Earth: G | Mars: (S) HHLC ");
		
		//Transitions
		Transition TQ0 = new Transition("LC",Q1);
		Transition TQ0Back = new Transition("LC",Q0);
		
		Transition TQ1 = new Transition("L",Q2);
		Transition TQ1Back = new Transition("L",Q1);
		Transition TQ01 = new Transition("C",Q8);
		Transition TQ01Back = new Transition("C",Q1);
		
		Transition TQ2 = new Transition("LG",Q3);
		Transition TQ2Back = new Transition("LG",Q2);
		Transition TQ02 = new Transition("HL",Q9);
		Transition TQ02Back = new Transition("HL",Q2);
		Transition TQ002 = new Transition("HH",Q11);
		Transition TQ002Back = new Transition("HH",Q2);
		
		Transition TQ3 = new Transition("C",Q4);
		Transition TQ3Back = new Transition("C",Q3);
		Transition TQ03 = new Transition("LC",Q16);
		Transition TQ03Back = new Transition("LC",Q3);
		Transition TQ003 = new Transition("CG",Q8);
		Transition TQ003Back = new Transition("CG",Q3);
		
		Transition TQ4 = new Transition("HH",Q5);
		Transition TQ4Back = new Transition("HH",Q4);
		Transition TQ04 = new Transition("HC",Q15);
		Transition TQ04Back = new Transition("HC",Q4);
		
		
		Transition TQ5 = new Transition("L",Q6);
		Transition TQ5Back = new Transition("L",Q5);
		Transition TQ05 = new Transition("LG",Q2);
		Transition TQ05Back = new Transition("LG",Q5);
		
		Transition TQ6 = new Transition("LC",Q7);
		Transition TQ06 = new Transition("C",Q13);
		
		Transition TQ8 = new Transition("HC",Q9);
		Transition TQ8Back = new Transition("HC",Q8);
		Transition TQ08 = new Transition("CG",Q3);
		Transition TQ08Back = new Transition("CG",Q8);
		
		Transition TQ9 = new Transition("LC",Q10);
		Transition TQ9Back = new Transition("LC",Q9);
		Transition TQ09 = new Transition("LC",Q2);
		Transition TQ09Back = new Transition("LC",Q9);
		
		Transition TQ10 = new Transition("HC",Q11);
		Transition TQ10Back = new Transition("HC",Q10);
		
		Transition TQ11 = new Transition("C",Q12);
		Transition TQ11Back = new Transition("C",Q11);
		Transition TQ011 = new Transition("HH",Q2);
		Transition TQ011Back = new Transition("HH",Q11);
		
		Transition TQ12 = new Transition("CG",Q13);
		Transition TQ12Back = new Transition("CG",Q12);
		Transition TQ012 = new Transition("LG",Q5);
		Transition TQ012Back = new Transition("LG",Q13);
		Transition TQ0012 = new Transition("LC",Q17);
		Transition TQ0012Back = new Transition("LC",Q12);
		
		Transition TQ13 = new Transition("HC",Q14);
		Transition TQ13Back = new Transition("HC",Q13);
		Transition TQ013 = new Transition("C",Q6);
		Transition TQ013Back = new Transition("C",Q6);
		
		Transition TQ14 = new Transition("LC",Q15);
		Transition TQ14Back = new Transition("LC",Q14);
		
		Transition TQ15 = new Transition("HC",Q4);
		Transition TQ15Back = new Transition("HC",Q15);
		
		//Adding the transition to the state
		Q0.addTransition(TQ0);
		Q1.addTransition(TQ0Back);
		
		Q1.addTransition(TQ1);
		Q2.addTransition(TQ1Back);
		Q1.addTransition(TQ01);
		Q8.addTransition(TQ01Back);
		
		Q2.addTransition(TQ2);
		Q3.addTransition(TQ2Back);
		Q2.addTransition(TQ02);
		Q9.addTransition(TQ02Back);
		Q2.addTransition(TQ002);
		Q11.addTransition(TQ002Back);
		
		Q3.addTransition(TQ3);
		Q4.addTransition(TQ3Back);
		Q3.addTransition(TQ03);
		Q16.addTransition(TQ03Back);
		Q3.addTransition(TQ003);
		Q8.addTransition(TQ003Back);
		
		Q4.addTransition(TQ4);
		Q5.addTransition(TQ4Back);
		Q4.addTransition(TQ04);
		Q15.addTransition(TQ04Back);
		
		Q5.addTransition(TQ5);
		Q6.addTransition(TQ5Back);
		Q5.addTransition(TQ05);
		Q12.addTransition(TQ05Back);
		
		Q6.addTransition(TQ6);
		Q6.addTransition(TQ06);
		
		Q8.addTransition(TQ8);
		Q9.addTransition(TQ8Back);
		Q8.addTransition(TQ08);
		Q3.addTransition(TQ08Back);
		
		Q9.addTransition(TQ9);
		Q10.addTransition(TQ9Back);
		Q9.addTransition(TQ09);
		Q2.addTransition(TQ09Back);
		
		Q10.addTransition(TQ10);
		Q11.addTransition(TQ10Back);
		
		Q11.addTransition(TQ11);
		Q12.addTransition(TQ11Back);
		Q11.addTransition(TQ011);
		Q2.addTransition(TQ011Back);
		
		Q12.addTransition(TQ12);
		Q13.addTransition(TQ12Back);
		Q12.addTransition(TQ012);
		Q5.addTransition(TQ012Back);
		Q12.addTransition(TQ0012);
		Q17.addTransition(TQ0012Back);
		
		Q13.addTransition(TQ13);
		Q14.addTransition(TQ13Back);
		Q13.addTransition(TQ013);
		Q6.addTransition(TQ013Back);
		
		Q14.addTransition(TQ14);
		Q15.addTransition(TQ14Back);
	
		Q15.addTransition(TQ15);
		Q4.addTransition(TQ15Back);
		
		//Game itself
		int moves = 0;
		boolean cont = true;
		System.out.println("Legend: \n H - Human \n L - Lion \n C - Cow \n G - Grain \n Note: Enter by Hierarchy H->L->C->G");
		System.out.println("---------------------------------------------------------");
		Game game = new Game(Q0);
		String isMove;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> visited = new ArrayList ();
		while(cont != false) {
			System.out.println("Move # " + moves);
			System.out.println("Current State: " + game.getCurrState().getName() );
			System.out.println("Current Position: " + game.getCurrState().getPosition() );
			System.out.println("Input Move: ");
			isMove = sc.nextLine();
			System.out.println("Input Move: " + isMove);
			States advance = game.checkTransition(isMove);
			if(advance != null) {
				visited.add(advance.getName());
				System.out.print("States Visited: Q0 ");
				for(int j = 0; j < visited.size();j++) {
					System.out.print(" -> " + visited.get(j) );
				}
				moves++;
				if(advance.getisFinal() == true) {
					game = new Game(advance);
					System.out.println("Last state has been reached");
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
