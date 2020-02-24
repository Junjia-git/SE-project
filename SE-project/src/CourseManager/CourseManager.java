package CourseManager;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CourseManager {
	
	public static void main(String[] args) throws IOException {
		ArrayList<Course> CourseArray = new ArrayList<Course>();
		
		Date time = new Date();
		System.out.println("time : " + time.toString());
 
		CourseArray = getCouresInfoFromfile();
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
			switch(choice) {

			}
			switch(choice) {
				case "1":
					findAllCourses(CourseArray);
					break;
				case "2":
					addCourse(CourseArray);
					break;
				case "3":
					deleteCourse(CourseArray);
					break;
				case "4":
					updateCourse(CourseArray);
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
	
	public static void findAllCourses(ArrayList<Course> arr) {
		if (arr.size() == 0) {
			System.out.println("Sorry, no data was stored.");
			return;
		}
		System.out.println("Course ID\tCourse Name\tCourse Requirment \tTrainning Grup");
		for (int i=0; i<arr.size(); i++) {
			Course s = arr.get(i);
			System.out.println("    " + s.getId() + "\t         " + s.getName() + "\t            " + s.getReq() + "\t                " + s.getTrainGourp());
		}
	}
	
	public static void addCourse(ArrayList<Course> arr) throws IOException {
		boolean falg = false;
		String id = "0";
		while(true) {
			falg = false;
			System.out.println("Please enter course ID");
			Scanner sc = new Scanner(System.in);
			id = sc.nextLine();
			for (int i=0; i<arr.size(); i++) {
				Course s = arr.get(i);
				if (s.getId().equals(id)) {
					System.out.println();
					falg = true;
				}
			}
			if (falg) {
				System.out.println("Course ID was existed!");
			} else {
				break;
			}
		}
		System.out.println("Please enter course NAME");
		Scanner sc1 = new Scanner(System.in);
		String name = sc1.nextLine();
		System.out.println("Please enter course REQUIRMENT");
		Scanner sc2 = new Scanner(System.in);
		String req = sc2.nextLine();
		System.out.println("Please enter Trainning Group");
		Scanner sc3 = new Scanner(System.in);
		String trainGourp = sc3.nextLine();
//		Course s = new Course(id, name, req, trainGourp);
		Course s = new Course();
		s.setId(id);
		s.setName(name);
		s.setReq(req);
		s.setTrainGourp(trainGourp);
		
		arr.add(s);
		saveCoursesInfoTofile(arr);
		System.out.println("Add Successful!");
	}
	
	public static void deleteCourse(ArrayList<Course> arr) throws IOException {
		System.out.println("Please enter the Course ID you want to delete:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		boolean hasDelete = false;
		for (int i=0; i<arr.size(); i++) {
			Course s = arr.get(i);
			if (s.getId().equals(id)) {
				arr.remove(i);
				hasDelete = true;
				break;
			}
		}
		saveCoursesInfoTofile(arr);
		if (hasDelete)
			System.out.println("Course deleted!");
		else 
			System.out.println("Course not found!");
	}
	
	public static void updateCourse(ArrayList<Course> arr) throws IOException {
		System.out.println("Please enter the course ID which need update:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int index = -1;
		for (int i=0; i<arr.size(); i++) {
			Course s = arr.get(i);
			if (s.getId().equals(id)) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("Coures not found!");
		}
		else {
			Course s = arr.get(index);
			System.out.println("Please enter course NAME");
			Scanner sc1 = new Scanner(System.in);
			String name = sc1.nextLine();
			System.out.println("Please enter course REQUIRMENT");
			Scanner sc2 = new Scanner(System.in);
			String req = sc2.nextLine();
			System.out.println("Please enter Trainning Group");
			Scanner sc3 = new Scanner(System.in);
			String trainGourp = sc3.nextLine();
			s.setName(name);
			s.setTrainGourp(trainGourp);
			s.setReq(req);
			System.out.println("Update sucsessful!");
		}
		saveCoursesInfoTofile(arr);
	}
	
	public static void saveCoursesInfoTofile(ArrayList<Course> arr) throws IOException {
		BufferedWriter bw = null;
		String destFile = "./test.txt";
		File file = new File(destFile);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
			StringBuilder data = new StringBuilder();
			for (int i = 0; i<arr.size(); i++) {
				data.append(arr.get(i).getId());
				data.append("," + arr.get(i).getName());
				data.append("," + arr.get(i).getReq());
				data.append("," + arr.get(i).getTrainGourp());
				data.append("\n");
			}
			System.out.println(data);
			bw.write(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("File saved!");
	}
 
	public static ArrayList<Course> getCouresInfoFromfile() throws FileNotFoundException {
		String path = "./test.txt";
		BufferedReader br = null;
		ArrayList<Course> arr = new ArrayList<Course>();
		File file = new File(path);
		String CoursesInfo = "";
		try {
			if (file.exists()) {
				FileInputStream fileInputStream = new FileInputStream(path);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
				br = new BufferedReader(inputStreamReader);
				String infoData = null;
				while ((infoData = br.readLine()) != null) {
					CoursesInfo += infoData;
					CoursesInfo += "\n";
				}
//				System.out.println("----------" + CoursesInfo);
				br.close();
				
				String[] infoArr = CoursesInfo.split("\n");
				for (int i=0; i<infoArr.length; i++) {
					String[] stuArr = infoArr[i].split(",");
					if (stuArr.length > 0) {
						Course s = new Course();
						s.setId(stuArr[0]);
						s.setName(stuArr[1]);
						s.setReq(stuArr[2]);
						s.setTrainGourp(stuArr[3]);
						arr.add(s);
					}		
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return arr;
	}
}