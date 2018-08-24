import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Machine machine = new Machine();
					Game game = new Game(machine.getStates().get(0));
					GUI frame = new GUI(machine, game);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
