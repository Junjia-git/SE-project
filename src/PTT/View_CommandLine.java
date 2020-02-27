package PTT;

import java.io.IOException;
import java.util.Scanner;

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
		System.out.println("Welcome to Class Director Manager System!\n");
		System.out.println("1 > Course details");
		System.out.println("2 > Add a new course");
		System.out.println("3 > Delete courses");
		System.out.println("4 > Edit course details");
		System.out.println("5 > Log out");
		System.out.println("6 > EXIT\n");
		System.out.println("Please enter your choice：");
	}
	
	public void teacherManager() {
		System.out.println("\n");
		System.out.println("Welcome to Teacher Manager System!\n");
		System.out.println("1 > Teacher list");
		System.out.println("2 > Add a teacher to the list");
		System.out.println("3 > Delete a teacher from the list");
		System.out.println("4 > Edit the teacher list");
		System.out.println("5 > Login");
		System.out.println("6 > EXIT\n");
		System.out.println("Please enter your choice：");
	}
	
//	public void classDirectorIntialView(Model_ClassDirector mc, String filePath) {
//		System.out.println("\n" + "\n");
//		System.out.println("Class Director");
//		System.out.println("------------------------");
//		System.out.println("The Teaching Requirement");
//		System.out.println("------------------------");
//		mc.getTeachingRequirement(filePath);
//		mc.classDirectorList();
//		System.out.println("------------------");
//		System.out.println("**Next**" + "\n" + "1. Pass it to the teacher" + "\n" + "2. Edit");
//		System.out.println("------------------");
//	}
//	
//	public void classDirectorEditView(Model_ClassDirector mc) {
//		System.out.println("\n" + "\n");
//		System.out.println("------------------------");
//		System.out.println("**Editing**" + "\n" + "1. Add" + "\n" + "2. Remove");
//		System.out.println("------------------------");
//	}
//
//	
//	public void teacherView(Model_Teacher mt, Model_ClassDirector mc) {
//		System.out.println("\n" + "\n");
//		System.out.println("Teacher");
//		System.out.println("------------");
//		System.out.println("Teacher List");
//		System.out.println("------------");
//		if (mc.getAddCounter()==0 && mc.getRemoveCounter()==0) {
//			mc.withoutEdit();
//			mt.matchClass();
//		}
//		if (mc.getAddCounter()==1 && mc.getRemoveCounter()==0) {
//			mc.addListMethod();
//			mt.matchClass();
//			mc.setAddCounter(0);
//		}
//		if (mc.getAddCounter()==0 && mc.getRemoveCounter()==1) {
//			mc.removeListMethod();
//			mt.matchClass();
//			mc.setRemoveCounter(0);
//		}
//		else {
//			System.err.println("Cannot add and remove at the same time!");
//
//		}
//		System.out.println("------------------");
//		System.out.println("**Next**" + "\n" + "1. Pass it to the Administrator" + "\n" + "2. Edit");
//		System.out.println("------------------");
//	}
	
//	public void addThenPassToTeacherView(Model_Teacher mt, Model_ClassDirector mc) {
//		System.out.println("\n" + "\n");
//		System.out.println("Teacher");
//		System.out.println("------------");
//		System.out.println("Teacher List");
//		System.out.println("Class Director added some lecturers in the teacher list");
//		System.out.println("------------");
//		mc.addListMethod();
//		mt.matchClass();
//		System.out.println("------------------");
//		System.out.println("**Next**" + "\n" + "1. Pass it to the Administrator" + "\n" + "2. Edit");
//		System.out.println("------------------");
//	}
//	
//	public void removeThenPassToTeacherView(Model_Teacher mt, Model_ClassDirector mc) {
//		System.out.println("\n" + "\n");
//		System.out.println("Teacher");
//		System.out.println("------------");
//		System.out.println("Teacher List");
//		System.out.println("Class Director removed some lecturers in the teacher list");
//		System.out.println("------------");
//		mc.removeListMethod();
//		mt.matchClass();
//		System.out.println("------------------");
//		System.out.println("**Next**" + "\n" + "1. Pass it to the Administrator" + "\n" + "2. Edit");
//		System.out.println("------------------");
//	}
	
	
	public void administratorView() {
		System.out.println("\n" + "\n");
		System.out.println("Administrator");
		System.out.println("--------------");
		System.out.println("Selection List");
		System.out.println("--------------");
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
