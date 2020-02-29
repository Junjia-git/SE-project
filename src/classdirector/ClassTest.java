package classdirector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassTest {

	public static void main(String[] args) throws IOException {
		ArrayList<ClassInformation> CourseArray = new ArrayList<ClassInformation>();
		ClassDirector cd=new ClassDirector();
		cd.getCourseInfo();
		for (int i=0; i<CourseArray.size(); i++) {
//			System.out.println(CourseArray.get(i).getName());
		}
//		if(choice,contains("1")) {
//			boolean flag = true;
//			while(flag) {
//				System.out.println("----------Choose your identity----------");
//				System.out.println("1.Class director");
//				System.out.println("2.Administrator");
//				System.out.println("3.PTT Director");
//			}
//		}
		while(true) {
			System.out.println("Welcome to Course Manager System!\n");
			System.out.println("1 for all course detail");
			System.out.println("2 for add new course");
			System.out.println("3 for delete course");
			System.out.println("4 for modify course detail");
			System.out.println("5 for EXIT\n");
			System.out.println("Please enter your chose：");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
//			switch(choice) {
//
//			}
			switch(choice) {
				case "1":
					cd.findAllCourses();
					break;
				case "2":
					cd.addCourseInfo();
					break;
				case "3":
					cd.deleteCourse();
					break;
				case "4":
					cd.updateCourse();
				case "5":
					System.out.println("Thanks for using Course Manager!");
					System.exit(0);
					
					break;
//				default:
//					System.out.println("Thanks for using！choice = " + choice);
//					System.out.println("Thanks for using Course Manager");
//					System.exit(0);
//					break;
			}
		}
	}
}