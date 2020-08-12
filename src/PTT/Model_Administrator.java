package PTT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Model_Administrator {
	Model_TeacherAndClass ta;
	private ArrayList<Model_TeacherAndClass> teachersAndClassesList; 
	private ArrayList<Model_TeacherAndClass> requestsList;
	private ArrayList<Model_TeachingRequirement> courseList;
	private int courseCounter;
	private String filePath;
	private boolean firstEnter;

	
	public Model_Administrator(String filePath) {
		teachersAndClassesList = new ArrayList<Model_TeacherAndClass>();
		requestsList = new ArrayList<Model_TeacherAndClass>();
		ta = new Model_TeacherAndClass();
		courseList = new ArrayList<Model_TeachingRequirement>();
		courseCounter = 0;
		firstEnter = true;
		this.filePath = filePath;
	}
	
	
	
	public ArrayList<Model_TeacherAndClass> getTeachersAndClassesList() {
		return teachersAndClassesList;
	}



	public void setTeachersAndClassesList(ArrayList<Model_TeacherAndClass> teachersAndClassesList) {
		this.teachersAndClassesList = teachersAndClassesList;
	}



	public ArrayList<Model_TeacherAndClass> getRequestsList() {
		return requestsList;
	}



	public void setRequestsList(ArrayList<Model_TeacherAndClass> requestsList) {
		this.requestsList = requestsList;
	}



	public ArrayList<Model_TeachingRequirement> getCourseList() {
		return courseList;
	}



	public void setCourseList(ArrayList<Model_TeachingRequirement> courseList) {
		this.courseList = courseList;
	}



	public int getCourseCounter() {
		return courseCounter;
	}



	public void setCourseCounter(int courseCounter) {
		this.courseCounter = courseCounter;
	}



	public void readTeachingRequests() {
		teachersAndClassesList.removeAll(teachersAndClassesList);
		
		File src = new File(filePath);
		BufferedReader br = null;
		String requestsDraft = "";
		
		try {
			if (src.exists()) {
				FileInputStream fileInputStream = new FileInputStream(src);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
				br = new BufferedReader(inputStreamReader);
				
				String requestsInfo = null;
				while((requestsInfo = br.readLine()) != null) {
					requestsDraft += requestsInfo;
					requestsDraft += "\n";
				}
				br.close();
				
				String[] rowArr = requestsDraft.split("\n");
				for (int i = 0; i < rowArr.length; i++) {
					String[] columnArr = rowArr[i].split("\t", 5);
					
					if (columnArr.length>0) {
						Model_TeacherAndClass list = new Model_TeacherAndClass();
						list.setCouseID(columnArr[0]);
						list.setCourseName(columnArr[1]);
						list.setCourseTeacherReq(columnArr[2]);
						list.setLecturerIDWithDegree(columnArr[3]);
						teachersAndClassesList.add(list);
						
					}else {
						System.err.println("Failed to read the file!");
					}
				}
				
			}else {
				System.err.println("File not found!");
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
	}
	
	public void printOutList() {
		if (teachersAndClassesList.size() == 0) {
			System.err.println("Sorry, no data in the list!");
			return;
		}
		for (int i=0; i<teachersAndClassesList.size(); i++) {
			Model_TeacherAndClass s = teachersAndClassesList.get(i);
			System.out.println(s.getCouseID() + "\t" + s.getCourseName() + "\t" 
			+ s.getCourseTeacherReq() + "\t" + s.getLecturerIDWithDegree());
		}
	}
	
	public void selectLecturers() {
		
		System.out.println("Please enter a course ID:");;
		Scanner s1 = new Scanner(System.in);
		String courseID = s1.nextLine();
		
		System.out.println("Please enter a lecturerID");
		Scanner s2 = new Scanner(System.in);
		String lecturerID = s2.nextLine();
		
		for (int i = 0; i < teachersAndClassesList.size(); i++) {
			Model_TeacherAndClass list = teachersAndClassesList.get(i);
			
			if (courseID.equals(teachersAndClassesList.get(i).getCouseID())
					&& teachersAndClassesList.get(i).getLecturerIDWithDegree().contains(lecturerID)
					) {
				requestsList.add(list);
				courseCounter--;
				
				String classID = teachersAndClassesList.get(i).getCouseID();
				for (int j = 0; j < courseList.size(); j++) {
					if (classID.equals(courseList.get(j).getCouseID())) {
						courseList.remove(j);
					}
				}
				
				for (int j = 0; j < teachersAndClassesList.size(); j++) {
					if (classID.equals(teachersAndClassesList.get(j).getCouseID())) {
						teachersAndClassesList.remove(j);
					}
				}
			}
		}

	}
	
	public void selectView(Model_ClassDirector course) {
		if (firstEnter) {
			courseList.removeAll(courseList);
			requestsList.removeAll(requestsList);
			courseCounter = course.getCourseCounter()-1;
			System.out.println("\n" + "There are " + courseCounter + " courses left to be selected." + "\n");
			System.out.println("---------------------------------");
			for (int i = 1; i < course.getInitalList().size(); i++) {
				System.out.println(course.getInitalList().get(i).getCouseID() + "\t"+ course.getInitalList().get(i).getCourseName());
				Model_TeachingRequirement s = course.getInitalList().get(i);
				courseList.add(s);
			}
			System.out.println("---------------------------------");
			firstEnter = false;
			printOutList();
			
			Model_TeacherAndClass title = new Model_TeacherAndClass();
			title.setCouseID("Course ID");
			title.setCourseName("Course Name");
			title.setCourseTeacherReq("Requirement");
			title.setLecturerIDWithDegree("Lecturer(Degree)");
			requestsList.add(title);
			
		}else {
			System.out.println("\n" + "There are " + courseCounter + " courses left to be selected." + "\n");
			System.out.println("---------------------------------");
			for (int i = 0; i < courseList.size(); i++) {
				System.out.println(courseList.get(i).getCouseID() + "\t" + courseList.get(i).getCourseName());
			}
			System.out.println("---------------------------------");
//			System.out.println(courseList.size());
			
			printOutList();
		}
	}
	
	
	
	public void printOutRequestsList() {
		if (requestsList.size() == 0) {
			System.err.println("Sorry, no data in the list!");
			return;
		}
		for (int i=0; i<requestsList.size(); i++) {
			Model_TeacherAndClass s = requestsList.get(i);
			System.out.println("\n" + s.getCouseID() + "\t" + s.getCourseName() + "\t" 
			+ s.getCourseTeacherReq() + "\t" + s.getLecturerIDWithDegree());
		}
	}
	

	public void writeToFile() {
		firstEnter = true;
		BufferedWriter writer = null;

		File file = new File(filePath);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (requestsList.size()>0) {
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
				StringBuilder data = new StringBuilder();
				
				for (int i = 0; i < requestsList.size(); i++) {
					data.append(requestsList.get(i).getCouseID());
					data.append("\t" + requestsList.get(i).getCourseName());
					data.append("\t" + requestsList.get(i).getCourseTeacherReq());
					data.append("\t" + requestsList.get(i).getLecturerIDWithDegree());
					data.append("\r\n");
				}
				
//				System.out.println(data);
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
			System.out.println("\n"+"File saved!");
		}else {
			System.err.println("No data to be saved!" + "\n" + "Please match the courses first!");
		}
	}
	
	
	
	
}