import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Machine machine = new Machine();

		try {
			Controller c = new Controller(machine);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
