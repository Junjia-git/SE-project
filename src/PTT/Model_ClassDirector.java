package PTT;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class Model_ClassDirector {
	private ArrayList<Model_TeachingRequirement> classTeachingRequirements;
	private ArrayList<Model_TeachingRequirement> initalList;
	private ArrayList<Model_TeacherList> teacherInitalList;
	private int courseCounter = 0;
	private boolean added = false;
	private boolean removed = false;
	private int removeID = 0;
	String filePath;
	
	public Model_ClassDirector(String filePath) {
		classTeachingRequirements = new ArrayList<Model_TeachingRequirement>();
		initalList = new ArrayList<Model_TeachingRequirement>();
		teacherInitalList = new ArrayList<Model_TeacherList>();
		this.filePath = filePath;
	}

	public ArrayList<Model_TeachingRequirement> getClassTeachingRequirements() {
		return classTeachingRequirements;
	}
	
	public ArrayList<Model_TeachingRequirement> getInitalList() {
		return initalList;
	}
	
	
	public int getCourseCounter() {
		return courseCounter;
	}

	public void setCourseCounter(int courseCounter) {
		this.courseCounter = courseCounter;
	}

	public ArrayList<Model_TeacherList> getTeacherInitalList() {
		return teacherInitalList;
	}

	public void setTeacherInitalList(ArrayList<Model_TeacherList> teacherInitalList) {
		this.teacherInitalList = teacherInitalList;
	}
	
	public void resetCourseInfo() {
		classTeachingRequirements.removeAll(classTeachingRequirements);
		initalList.removeAll(initalList);
	}
	
	public void resetTeacherInfo() {
		teacherInitalList.removeAll(teacherInitalList);
	}

	public void getCourseInfo()throws FileNotFoundException{
		resetCourseInfo();
		courseCounter = 0;
		File src = new File(filePath);
		LineNumberReader lineReader = null;
		String coursesInfo ="";
		
		try {
			if (src.exists()) {
				FileInputStream fileInputStream = new FileInputStream(src);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
				lineReader = new LineNumberReader(inputStreamReader);
				
				String infoData = null;
				while ((infoData = lineReader.readLine()) != null) {
					if (lineReader.getLineNumber() >=12) {
						coursesInfo += infoData;
						coursesInfo += "\n";
					}
					
				}

				lineReader.close();
				String[] infoArr = coursesInfo.split("\n");
//				System.out.println(infoArr.length);
				
				for (int i=0; i<infoArr.length; i++) {
					String[] stuArr = infoArr[i].split("\t", 5);
					
//					System.out.println(stuArr.length);

					if (stuArr.length>0) {
						Model_TeachingRequirement mtr = new Model_TeachingRequirement();
						mtr.setCouseID(stuArr[0]);
						mtr.setCourseName(stuArr[1]);
						mtr.setCourseTeacherReq(stuArr[2]);
						mtr.setCoursetime(stuArr[3]);
						mtr.setCourseLocation(stuArr[4]);
						initalList.add(mtr);
						classTeachingRequirements.add(mtr);
						courseCounter++;
					}else {
						System.err.println("Failed to read the file!");
					}
				}
				
			}else {
				System.err.println("File not found!");
			}
				
			}catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (lineReader != null) {
					try {
						lineReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	
	
	
	public void getTeacherInfo() {
		resetTeacherInfo();
//		System.out.println(teacherInitalList.size());
		File src = new File(filePath);
		LineNumberReader lineReader = null;
		String teacherList ="";
		
		try {
			FileInputStream fileInputStream = new FileInputStream(src);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			lineReader = new LineNumberReader(inputStreamReader);
			
			String infoData = null;
			while ((infoData = lineReader.readLine()) != null) {
				if (lineReader.getLineNumber() == 12) {
					break;
				}
					teacherList += infoData;
					teacherList += "\n";
//					System.out.println(lineReader.getLineNumber());
//					System.out.println(teacherList);
			}
			lineReader.close();
			if (src.exists()) {
				String[] teacherArr = teacherList.split("\n");
//				System.out.println(teacherArr.length);
				
				for (int i = 0; i < teacherArr.length; i++) {
					String[] teaListArr = teacherArr[i].split("\t", 5);
					
					if (teaListArr.length>0) {
						Model_TeacherList mtl = new Model_TeacherList();
						mtl.setLecturerID(teaListArr[0]);
						mtl.setLecturerName(teaListArr[1]);
						mtl.setDegree(teaListArr[2]);
						mtl.setMainCourse(teaListArr[3]);
						mtl.setOtherCourseTeaching(teaListArr[4]);
						teacherInitalList.add(mtl);
					}
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (lineReader != null) {
				try {
					lineReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public void findAllCourses() {
		
		if (classTeachingRequirements.size() == 0) {
			System.err.println("Sorry, no data in Course List!");
			return;
		}
//		System.out.println("Course ID\tCourse Name\tCourse TeacherRequ \tCourse Time \tCourse Location");
		for (int i=0; i<classTeachingRequirements.size(); i++) {
			Model_TeachingRequirement s = classTeachingRequirements.get(i);
			System.out.println(s.getCouseID() + "\t" + s.getCourseName() + "\t"
			+ s.getCourseTeacherReq() + "\t" + s.getCoursetime() + "\t" + s.getCourseLocation());
		}
	}
	
	
	public void addCourseInfo() throws IOException{
		boolean falg = false;
		String id = "";
		while(true) {
			falg = false;
			System.out.println("Please enter course ID");
			Scanner sc = new Scanner(System.in);
			id = sc.nextLine();
			for (int i=0; i<classTeachingRequirements.size(); i++) {
				Model_TeachingRequirement s = classTeachingRequirements.get(i);
				if (s.getCouseID().equals(id)) {
					falg = true;
				}
			}
			if (falg) {
				System.out.println("Course ID was existed!");
			} else {
				break;
			}
//			sc.close();
		}
		System.out.println("Please enter course Name");
		Scanner sc1 = new Scanner(System.in);
		String name = sc1.nextLine();
//		sc1.close();
		
		System.out.println("Please enter course Teacher Requirement");
		Scanner sc2 = new Scanner(System.in);
		String teacherreq = sc2.nextLine();
//		sc2.close();
		
		System.out.println("Please enter course Time");
		Scanner sc3 = new Scanner(System.in);
		String time = sc3.nextLine();
//		sc3.close();
		
		System.out.println("Please enter course Location");
		Scanner sc4 = new Scanner(System.in);
		String location = sc3.nextLine();
//		sc4.close();
		Model_TeachingRequirement course = new Model_TeachingRequirement();
		course.setCouseID(id);
		course.setCourseName(name);
		course.setCourseTeacherReq(teacherreq);
		course.setCoursetime(time);
		course.setCourseLocation(location);
		
		classTeachingRequirements.add(course);
		
		added = true;
		courseCounter++;
//		System.out.println(courseCounter);
		
		saveCoursesInfoTofile();
		System.out.println("Add Successful!");
		
	}
	
	public void deleteCourse() throws IOException {
		System.out.println("Please enter the Course ID you want to delete:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
//		sc.close();
		boolean hasDelete = false;
		for (int i=0; i<classTeachingRequirements.size(); i++) {
			Model_TeachingRequirement ci = classTeachingRequirements.get(i);
			if (ci.getCouseID().equals(id)) {
				removed = true;
				courseCounter--;
				removeID = i;
				saveCoursesInfoTofile();
				classTeachingRequirements.remove(i);
				hasDelete = true;
				break;
			}
		}
		
		
		if (hasDelete)
			System.out.println("\n" + "Course deleted!");
		else 
			System.out.println("\n" + "Course not found!");
	}
					
	
	
	public void saveCoursesInfoTofile() throws IOException {
		
		BufferedWriter writer = null;

		File file = new File(filePath);
		FileReader in = new FileReader(file);  
        BufferedReader bufIn = new BufferedReader(in);  

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		try {

			if (added) {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
			StringBuilder data = new StringBuilder();
			int c = courseCounter-1;
//			System.out.println(courseCounter);
				data.append("\n");
				data.append(classTeachingRequirements.get(c).getCouseID());
				data.append("\t" + classTeachingRequirements.get(c).getCourseName());
				data.append("\t" + classTeachingRequirements.get(c).getCourseTeacherReq());
				data.append("\t" + classTeachingRequirements.get(c).getCoursetime());
				data.append("\t" + classTeachingRequirements.get(c).getCourseLocation());
//				data.append("\r\n");
				added = false;
				writer.write(data.toString());
			}
			
			if (removed) {
				
				Model_TeachingRequirement s = classTeachingRequirements.get(removeID);
				String oldChar = s.getCouseID() + "\t"  + s.getCourseName() + "\t" 
						+ s.getCourseTeacherReq() + "\t" + s.getCoursetime() + "\t"  + s.getCourseLocation();
				
				String newChar = "";
				
				CharArrayWriter  tempStream = new CharArrayWriter();  
		        String line = null;  
		        while ( (line = bufIn.readLine()) != null) {  
		            line = line.replaceAll(oldChar, newChar);  
		            tempStream.write(line);  
		            tempStream.append(System.getProperty("line.separator"));  
		        }  
				
		        bufIn.close();
		        
		        FileWriter out = new FileWriter(file);  
		        tempStream.writeTo(out);  
		        out.close(); 
				removed = false;
				}
				
			
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
	
		System.out.println("\n" + "File saved!");
	}
	
	
	
	

}
