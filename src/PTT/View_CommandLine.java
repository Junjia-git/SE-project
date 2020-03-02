package PTT;

public class View_CommandLine {
	private View_UserSelection userSelection;
	
	public View_CommandLine() {
		userSelection = new View_UserSelection();
	}

	public View_UserSelection getUserSelection() {
		return userSelection;
	}

	public void startRunning() {
		System.out.println("----------------------------------");	
		System.out.println("**Teaching and Employment System**");
		System.out.println("----------------------------------");
		System.out.println("Welecome! Please login first.");
	}
	
	public void userLogIn() {
		System.out.println("\n");
		System.out.println("**Login**");
		System.out.println("------------------");
		System.out.println("1. Class Director" + "\n" + "2. Teacher" + "\n" + 
							"3. Administrator" + "\n" +  "4. PTT Director" + "\n" + "5. EXIT");
		System.out.println("------------------");
 
	}
	
	public void classManager() {
		System.out.println("\n");
		System.out.println("**Class Director**");
		System.out.println("------------------");
		System.out.println("Welcome to The Class Director Manager System!\n");
		System.out.println("1 > Course details");
		System.out.println("2 > Add a new course");
		System.out.println("3 > Delete courses");
		System.out.println("4 > Log out");
		System.out.println("5 > EXIT\n");
		System.out.println("Please enter your choice：");
		System.out.println("--------------------------");
	}
	
	public void teacherManager() {
		System.out.println("\n");
		System.out.println("**Teacher**");
		System.out.println("------------");
		System.out.println("Welcome to The Teacher Manager System!\n");
		System.out.println("1 > Teacher list");
		System.out.println("2 > Match the courses");
		System.out.println("3 > Save");
		System.out.println("4 > Log out");
		System.out.println("5 > EXIT\n");
		System.out.println("Please enter your choice：");
		System.out.println("--------------------------");
	}
	
	
	public void administratorManager() {
		System.out.println("\n");
		System.out.println("**Administrator**");
		System.out.println("-----------------");
		System.out.println("Welcome to The Administrator Manager System!\n");
		System.out.println("1 > Requests list");
		System.out.println("2 > Select suitable lecturers");
		System.out.println("3 > Print out Requests List");
		System.out.println("4 > Save the list");
		System.out.println("5 > Log out");
		System.out.println("6 > EXIT\n");
		System.out.println("Please enter your choice：");
		System.out.println("--------------------------");
	}
	
	
	
	public void pttDirectorView(Model_PTTDirector mp, String filepath) {
		System.out.println("\n" + "\n");
		System.out.println("PTT Director");
		System.out.println("------------------");
		System.out.println("The teaching requests are ready. Please check!");
//		mp.readTeachingRequests(filepath);
		System.out.println("Do you want to approve these requests above?" + "\n" + "Press 1 - Yes" + "\n" + "Press 2 - No");
		
	}
	
	public void worngInput() {
		System.err.println("Undefined input. Please enter a number again!");
	}
	
//	public void saveAndLogin() {
//		System.out.println("THE CONTENT IS UPDATED");
//		userLogIn();
//	}

	public void afterEditingThenPass() {
		System.out.println("Edit successfully!" + "\n" + "Now pass the teaching requirement to the teacher automatically");

	}
}
