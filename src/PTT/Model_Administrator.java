package PTT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Model_Administrator {
	Model_TeacherAndClass ta;
	private static ArrayList<Model_TeacherMatch> results;
	private static ArrayList<String> requests;
	private ArrayList<Model_TeacherAndClass> teachersAndClasses; 
	String filePath;

	
	public Model_Administrator(String filePath) {
		teachersAndClasses = new ArrayList<Model_TeacherAndClass>();
		ta = new Model_TeacherAndClass();
		results=new ArrayList<Model_TeacherMatch>();
		requests = new ArrayList<>();
		this.filePath = filePath;
	}
	
	public void readTeachingRequests(Model_TeacherAndClass ta) {
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			
			String readData;
			while ((readData = br.readLine())!= null) {
				try {
					requests.add(readData);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			br.close();
			fr.close();
			for (int i = 0; i < requests.size(); i++) {
				System.out.println(requests.get(i));
			}
//			System.out.println(requests.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showResults(Model_Teacher teacher) {
		teacher.showMatchResults();
		teachersAndClasses=teacher.getArray();
		System.out.println("please enter the course id which need choose leturer");
		Scanner sc=new Scanner(System.in);
		String id=sc.nextLine();
		int index=-1;
		for (int i = 0; i < teachersAndClasses.size(); i++) {
			 ta=teachersAndClasses.get(i);
			 if (ta.getCouseID().equals(id)) {
				index=i;
			}
		}
		if (index==-1) {
			System.out.println("course not found");
		}
		else {
			Model_TeacherMatch tm=new Model_TeacherMatch();
			if (ta.getLecturerIDWithDegree().length()>1) {
				System.out.println("please enter the choosed teacher");
				Scanner sa=new Scanner(System.in);
				String lecturer=sa.nextLine();
				tm.setCourseID(id);
				tm.setLecturerMatch(lecturer);
			}else {
				String lecturer1=ta.getLecturerIDWithDegree();
				tm.setCourseID(id);
				tm.setLecturerMatch(lecturer1);
			}
		}
		writeToFile();
	}
	

	public void writeToFile() {

		BufferedWriter writer = null;

		File file = new File(filePath);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (teachersAndClasses.size()>0) {
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "UTF-8"));
				StringBuilder data = new StringBuilder();
				
				for (int i = 0; i < teachersAndClasses.size(); i++) {
					data.append(teachersAndClasses.get(i).getCouseID());
					data.append("\t" + teachersAndClasses.get(i).getCourseName());
					data.append("\t" + teachersAndClasses.get(i).getCourseTeacherReq());
					data.append("\t" + results.get(i).getLecturerMatch());
					data.append("\r\n");
				}
				
				System.out.println(data);
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
