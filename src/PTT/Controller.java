package PTT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	private Model_ClassDirector mc;
	private Model_Teacher mt;
	private Model_Administrator ma;
	private Model_PTTDirector mp;
	private View_CommandLine vc;
	private Model_TeachingRequirement mtr;
	private Model_TeacherList mtl;
	private View_UserSelection vu = new View_UserSelection();

//	int lineNumber;
	
	public Controller(Model_ClassDirector mc, Model_Teacher mt, 
			Model_Administrator ma, Model_PTTDirector mp, 
			View_CommandLine vc, Model_TeacherList mtl, Model_TeachingRequirement mtr) {
		this.mc = mc;
		this.mt = mt;
		this.ma = ma;
		this.mp = mp;
		this.vc = vc;
		this.mtr =mtr;
		this.mtl = mtl;
		
	}
	
	public void startRunning(String filePath) throws IOException {
		vc.startRunning();
//		int userInputA = vc.getUserSelection().userSelectionListener();
//		if (userInputA == 1) {
		loginManagement(filePath);
		
//		classDirectorProducing(filePath);
//		}
//		else if (userInputA == 2) {
			
//		}else {
//			vc.worngInput();
//			startRunning(filePath);
//		}
		
	}
	
	public void loginManagement(String filePath) throws IOException {
		vc.userLogIn();
		int userInputC = vc.getUserSelection().userSelectionListener();
		if (userInputC == 1) {
			classDirectorProducing(filePath);
		}
		if (userInputC == 2) {
			teacherListProducing(filePath);
		}
		if (userInputC == 3) {
			
		}
		if (userInputC == 4) {
			
		}
		if (userInputC == 5) {
			System.out.println("Quit Successfully!");
			System.exit(0);
		}
		else {
			vc.worngInput();
			loginManagement(filePath);
		}
	}
	
	public void passToAdmin() {
		
	}
	
	
	public void classDirectorProducing(String filePath) throws IOException {
		mc.getCourseInfo();
		while(true) {
			vc.classManager();
			int userInputB = vu.userSelectionListener();
			switch(userInputB) {
			case 1:
				mc.findAllCourses();
				break;
			case 2:
				mc.addCourseInfo(mtr);
				break;
			case 3:
				mc.deleteCourse(mtr);
				break;
			case 4:
				mc.updateCourse(mtr);
				break;
			case 5:
				System.out.println("\n" + "Log out successfully!" + "\n" + "System is still running.");
				loginManagement(filePath);
			case 6:
				System.out.println("Thanks for using Course Manager!");
				System.exit(0);
			default:
				vc.worngInput();
				classDirectorProducing(filePath);
			}
		}
		
	}

	
	public void teacherListProducing(String filePath) throws IOException {
		mc.getTeacherInfo();
		while(true) {
			vc.teacherManager();
			int userInputC = vu.userSelectionListener();
			switch(userInputC) {
			case 1:
				mt.getTeacherList(mc);
//				mt.printTeacherList();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("\n" + "Log out successfully!" + "\n" + "System is still running.");
				loginManagement(filePath);
			case 6:
				System.out.println("Thanks for using Teacher Manager!");
				System.exit(0);
			default:
				vc.worngInput();
				teacherListProducing(filePath);
			}
		}
	}
	
	
	

//	public void editRequirement(String filePath, String content) {
//		int input = vc.getUserSelection().userSelectionListener();
//		if (input == 1 && count == 1) {
//			mc.writeNewRequirement(filePath, content);
//			mc.setAddCounter(1);
//			vc.afterEditingThenPass();
//			vc.teacherView(mt, mc);
//		}
//		if (input == 2 && count == 1) {
//			mc.removeRequirement();
//			mc.setRemoveCounter(1);
//			vc.afterEditingThenPass();
//			vc.teacherView(mt, mc);
//		}
//		if (input == 1 && count == 2) {
//			
//		}
//		if (input == 2 && count == 2) {
//			
//		}
//		else {
//			vc.worngInput();
//			editRequirement(filePath, content);
//		}
//		
//	}
	
	
	

}
