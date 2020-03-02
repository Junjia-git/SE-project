package PTT;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
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
			classDirectorManagerSystem(filePath);
		}
		if (userInputC == 2) {
			teacherDirectorManangerSystem(filePath);
		}
		if (userInputC == 3) {
			adminStratorSystem(filePath);
		}
		if (userInputC == 4) {
			pttDirectorSystem();
		}
		if (userInputC == 5) {
			System.out.println("Quit Successfully!");
			resetTheFile(filePath);
			System.exit(0);
		}
		else {
			vc.worngInput();
			loginManagement(filePath);
		}
	}
	
	public void passToAdmin() {
		
	}
	
	
	public void classDirectorManagerSystem(String filePath) throws IOException {
		mc.getCourseInfo();
		while(true) {
			vc.classManager();
			int userInputB = vu.userSelectionListener();
			switch(userInputB) {
			case 1:
				mc.findAllCourses();
				break;
			case 2:
				mc.addCourseInfo();
				break;
			case 3:
				mc.deleteCourse();
				break;
			case 4:
				System.out.println("\n" + "Log out successfully!" + "\n" + "System is still running.");
				loginManagement(filePath);
			case 5:
				System.out.println("Thanks for using Course Manager!");
				resetTheFile(filePath);
				System.exit(0);
			default:
				vc.worngInput();
				classDirectorManagerSystem(filePath);
			}
		}
		
	}

	
	public void teacherDirectorManangerSystem(String filePath) throws IOException {
		mc.getTeacherInfo();
		while(true) {
			vc.teacherManager();
			int userInputC = vu.userSelectionListener();
			switch(userInputC) {
			case 1:
				mt.getTeacherList(mc);
				break;
			case 2:
				mt.matchTheCourse(mc);
				mt.showMatchResults();
				break;
			case 3:
				mt.writeToFile();
				break;
			case 4:
				System.out.println("\n" + "Log out successfully!" + "\n" + "System is still running.");
				loginManagement(filePath);
			case 5:
				System.out.println("Thanks for using Teacher Manager!");
				resetTheFile(filePath);
				System.exit(0);
			default:
				vc.worngInput();
				teacherDirectorManangerSystem(filePath);
			}
		}
	}
	
	
	
	public void adminStratorSystem(String filePath) throws IOException{
		ma.readTeachingRequests();
		while(true) {
			vc.administratorManager();
			int userInputD = vu.userSelectionListener();
			switch(userInputD) {
			case 1:
				ma.printOutList();
				break;
			case 2:
				adminSelect();
				break;
			case 3:
				ma.printOutRequestsList();
				break;
			case 4:
				ma.writeToFile();
				break;
			case 5:
				System.out.println("\n" + "Log out successfully!" + "\n" + "System is still running.");
				loginManagement(filePath);
			case 6:
				System.out.println("Thanks for using Teacher Manager!");
				resetTheFile(filePath);
				System.exit(0);
			default:
				vc.worngInput();
				adminStratorSystem(filePath);
			}
		}
	}
	
	public void adminSelect() {
		
		while(true) {
			ma.selectView(mc);
			ma.selectLecturers();
			if (ma.getCourseCounter() == 0) {
				System.out.println("\n"+ "Each course was selected with one lecturer." + "\n" + 
									"The Teaching Requests Are Ready Now!");
				break;
			}
			
		}
	}
	
	
	public void pttDirectorSystem() {
		
	}
	
	
	
	public void resetTheFile(String filePath) {
		
		BufferedWriter writer = null;
		File file = new File(filePath);
		
		if (mc.getTeacherInitalList().size()>0 && mc.getInitalList().size()>0) {
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (mc.getTeacherInitalList().size()>0) {
				try {
					writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
					StringBuilder data = new StringBuilder();
					
					for (int i = 0; i < mc.getTeacherInitalList().size(); i++) {
						data.append(mc.getTeacherInitalList().get(i).getLecturerID());
						data.append("\t" + mc.getTeacherInitalList().get(i).getLecturerName());
						data.append("\t" + mc.getTeacherInitalList().get(i).getDegree());
						data.append("\t" + mc.getTeacherInitalList().get(i).getMainCourse());
						data.append("\t" + mc.getTeacherInitalList().get(i).getOtherCourseTeaching());
						data.append("\r\n");
					}
					
					for (int i = 0; i < mc.getInitalList().size(); i++) {
//						data.append("\n");
						data.append(mc.getInitalList().get(i).getCouseID());
						data.append("\t" + mc.getInitalList().get(i).getCourseName());
						data.append("\t" + mc.getInitalList().get(i).getCourseTeacherReq());
						data.append("\t" + mc.getInitalList().get(i).getCoursetime());
						data.append("\t" + mc.getInitalList().get(i).getCourseLocation());
						data.append("\r\n");
					}
					
					writer.write(data.toString());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (writer != null) {
							writer.close();
						}
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Reset File Successfully!");

			}else {
				System.err.println("Please Login Class Director First!");
			}
			
		}else {
			System.err.println("No data!");
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
