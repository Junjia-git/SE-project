package PTT;

import java.util.Scanner;

public class View_UserSelection {
	public int userSelectionListener() {
		
		Scanner scanner = new Scanner(System.in);
		int userChoice = scanner.nextInt();
		// change to nextline
		scanner.nextLine();
		scanner.close();
		//Controller.actionControl(e);
		return userChoice;
}


}