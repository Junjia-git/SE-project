package PTT;

public class View_CommandLine {
	private View_UserSelection userSelection;
	
	public View_CommandLine() {
		userSelection = new View_UserSelection();
	}

	public View_UserSelection getUserSelection() {
		return userSelection;
	}

	
	public void userChoice() {
		System.out.println("**PTT Software**");
		System.out.println("Choose your role: ");
		System.out.println("------------------");
		System.out.println("1. Class Director " + "\n" + "2. Administrator" + "\n" + "3. PTT Director" + "\n" + "4. Teacher" + "\n");
	}
	
	public void classDirectorView(Model_ClassDirector mc) {
		System.out.println("\n" + "\n");
		System.out.println("Class Director");
		System.out.println("------------------");
		System.out.println("The teaching requirement is ready. Please check!");
		



	}
	
	public void administratorView() {
		
	}
	
	public void pttDirectorView(Model_PTTDirector mp) {
		System.out.println("\n" + "\n");
		System.out.println("PTT Director");
		System.out.println("------------------");
		System.out.println("The teaching requests are ready. Please check!");
		mp.readTeachingRequests();
		System.out.println("Do you want to approve these requests above?" + "\n" + "Press 1 - Yes" + "\n" + "Press 2 - No");
		
	}
	
	public void teacherView() {
		
	}
}
