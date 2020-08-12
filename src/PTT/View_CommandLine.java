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
		System.out.println("Wlecome! Please login first.");
	}
	
	public void userLogIn() {
		System.out.println("\n");
		System.out.println("**Login**");
		System.out.println("------------------");
		System.out.println("1. Class Director" + "\n" + "2. Teacher" + "\n" + 
							"3. Administrator" + "\n" +  "4. PTT Director" + "\n" + 
							"------------------" + "\n" + "5. See PTT Director comments" + "\n" + "6. Reset the file" + "\n" +
							"7. EXIT");
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
		System.out.println("Welcome to The Teacher Director Manager System!\n");
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
		System.out.println("Welcome to The Administrator System!\n");
		System.out.println("1 > Requests list");
		System.out.println("2 > Select suitable lecturers");
		System.out.println("3 > Print out Requests List");
		System.out.println("4 > Save the list");
		System.out.println("5 > Log out");
		System.out.println("6 > EXIT\n");
		System.out.println("Please enter your choice：");
		System.out.println("--------------------------");
	}
	
	
	
	public void pttDirectorManager(Model_PTTDirector mp, String filepath) {
		System.out.println("\n");
		System.out.println("**PTT Director**");
		System.out.println("----------------");
		System.out.println("Welcome to The PTT Director Manager System!\n");
		System.out.println("1 > The Teaching Requests List");
		System.out.println("2 > Approve or not");
		System.out.println("3 > Add comments");
		System.out.println("4 > Save the comments");
		System.out.println("5 > Log out");
		System.out.println("6 > EXIT\n");
		System.out.println("Please enter your choice：");
		System.out.println("--------------------------");
		
	}
	
	public void wrongInput() {
		System.err.println("\n" + "Undefined input. Please enter again!");
	}
	
//	public void saveAndLogin() {
//		System.out.println("THE CONTENT IS UPDATED");
//		userLogIn();
//	}

//	public void afterEditingThenPass() {
//		System.out.println("Edit successfully!" + "\n" + "Now pass the teaching requirement to the teacher automatically");
//
//	}
}
