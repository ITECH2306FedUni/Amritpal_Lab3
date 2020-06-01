package operation;

/**
 * @author Amritpal kaur ramana
 * @version 1.0
 * 
 * @created 20 may, 2020
 */
public class CouncilSystem {

	public static void main(String[] args) {
		CouncilSystem cs = new CouncilSystem();
		cs.startApplication();
	}

	private void startApplication() {
		MainMenu mm = new MainMenu();
		mm.operateMenu();	
	}

}
