package PTT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Model_Administrator {
	Model_TeacherAndClass ta;
	private static ArrayList<Model_TeacherMatch> results;
	private static ArrayList<String> requests;
	private ArrayList<Model_TeacherAndClass> teachersAndClassesList; 
	private ArrayList<Model_TeacherAndClass> requestsList;
	private 
	String filePath;
	private int index;
	private int counter1;
	private int counter2;

	
	public Model_Administrator(String filePath) {
		teachersAndClassesList = new ArrayList<Model_TeacherAndClass>();
		requestsList = new ArrayList<Model_TeacherAndClass>();
		ta = new Model_TeacherAndClass();
		results=new ArrayList<Model_TeacherMatch>();
		requests = new ArrayList<>();
		index = 0;
		counter1 = 0;
		counter2 = 0;
		this.filePath = filePath;
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
						list.setCourseName(columnArr[i]);
						list.setCourseTeacherReq(columnArr[i]);
						list.setLecturerIDWithDegree(columnArr[i]);
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
//		try {
//			FileReader fr = new FileReader(filePath);
//			BufferedReader br = new BufferedReader(fr);
//			
//			String readData;
//			while ((readData = br.readLine())!= null) {
//				try {
//					requests.add(readData);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			br.close();
//			fr.close();
//			for (int i = 0; i < requests.size(); i++) {
//				System.out.println(requests.get(i));
//			}
////			System.out.println(requests.toString());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public void printOutList() {
		if (teachersAndClassesList.size() == 0) {
			System.err.println("Sorry, no data in the list!");
			return;
		}
		for (int i=0; i<teachersAndClassesList.size(); i++) {
			Model_TeacherAndClass s = teachersAndClassesList.get(i);
			System.out.println(s.getCouseID() + "    " + s.getCourseName() + "     " 
			+ s.getCourseTeacherReq() + "    " + s.getLecturerIDWithDegree());
		}
	}
	
	public void selectLecturers() {
		if (teachersAndClassesList.size()>0) {
			for (int i = 0; i < teachersAndClassesList.size(); i++) {
				for (int j = 0; j < teachersAndClassesList.size(); j++) {
					if (teachersAndClassesList.get(i).getCouseID().equals(teachersAndClassesList.get(j).getCouseID())
							&& i != j) {
						if (teachersAndClassesList.get(i).getLecturerIDWithDegree().contains(teachersAndClassesList.get(i).getCourseTeacherReq())) {
							index = i;
							counter1++;
						}
						if (teachersAndClassesList.get(j).getLecturerIDWithDegree().contains(teachersAndClassesList.get(j).getCourseTeacherReq())) {
							index = j;
							counter2++;
						}
						addToRequestsList();
						teachersAndClassesList.removeAll(requestsList);
					}
				}
				
			}
			
			
			
		}else {
			System.err.println("Sorry, no data in the list!");
		}
		
	System.out.println("Please enter course ID:");;
	Scanner s1 = new Scanner(System.in);
	String courseID = s1.nextLine();
	
	System.out.println("Please enter lecturerID");
	Scanner s2 = new Scanner(System.in);
	String lecturerID = s2.nextLine();
	
	
	
	for (int i = 0; i < teachersAndClassesList.size(); i++) {
		Model_TeacherAndClass list = teachersAndClassesList.get(i);
		if (courseID.equals(teachersAndClassesList.get(i).getCouseID())
				&& teachersAndClassesList.get(i).getLecturerIDWithDegree().contains(lecturerID)) {
			requestsList.add(list);
		}
		teachersAndClassesList.removeAll(requestsList);
	}
	

		
	}
	
	
	public void addToRequestsList() {
		if (counter1 == counter2) {
			
		}
	}

	public void writeToFile() {

//		BufferedWriter writer = null;
//
//		File file = new File(filePath);
//		
//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (teachersAndClasses.size()>0) {
//			try {
//				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "UTF-8"));
//				StringBuilder data = new StringBuilder();
//				
//				for (int i = 0; i < teachersAndClasses.size(); i++) {
//					data.append(teachersAndClasses.get(i).getCouseID());
//					data.append("\t" + teachersAndClasses.get(i).getCourseName());
//					data.append("\t" + teachersAndClasses.get(i).getCourseTeacherReq());
//					data.append("\t" + results.get(i).getLecturerMatch());
//					data.append("\r\n");
//				}
//				
//				System.out.println(data);
//				writer.write(data.toString());
//				
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if (writer != null) {
//						writer.close();
//					}
//				} catch(IOException e) {
//					e.printStackTrace();
//				}
//			}
//			System.out.println("\n"+"File saved!");
//		}else {
//			System.err.println("No data to be saved!" + "\n" + "Please match the courses first!");
//		}
//		
		
	}
}