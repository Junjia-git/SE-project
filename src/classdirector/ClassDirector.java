package classdirector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import calss.Course;

public class ClassDirector {
	private ArrayList<ClassInformation> tempInfo;
	private ArrayList<ClassInformation> origInfo;
	
	// Constructor
	public ClassDirector() {
//		ClassInformation ci=new ClassInformation();
		origInfo=new ArrayList<ClassInformation>();
		tempInfo=new ArrayList<ClassInformation>();
//		String filePath = "./Teaching Requests.txt";
		//      initialText(filePath);
		//		writeRequest(filePath);
	}
	
			
	public ArrayList<ClassInformation> getOriginInfo(){
		return origInfo;
	}
	
	public ArrayList<ClassInformation> getTempClassInfo(){
		return tempInfo;
	}
	
	public void readText(String filePath) {
		File filename = new File(filePath);
		String result =new String();
		try {
			// read content from text
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			
			String line = null;
			while ((line = br.readLine()) != null) {
				result=result+line+"\r\n";
			}
			br.close();
//			this.origInfo.add(result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Course requirement:"+"\r\n"+result);
	}
	
	// Method
//	public void initialText(String filePath) {
//		File filename = new File(filePath);
//		try {
//			// read content from txt
//			FileReader reader = new FileReader(filename);
//			BufferedReader br = new BufferedReader(reader);
//
//			String firstline = br.readLine();
//			// classAttribute[0] is class description
//			String[] classInfo = firstline.split(" +");
//			
//			String valueString = null;
//			while ((valueString = br.readLine()) != null) {
//				// Split the attribute in an array
//				String[] valueArray = valueString.split(" +");
//				// create new object
//				ClassInformation ci=new ClassInformation();
//
//				for (int i = 0; i < valueArray.length; i++) {
//					if (i == 0) {
//						// if i=0, means the class description
//						ci.setCourseInfo(valueArray[0]);
//						// set the course description
//					} else {
//						//wheni!=0, it related to the class details
//						String key = classInfo[i];
//						String value = valueArray[i];
//
//						ci.giveValue(key, value);
//					}
//				}
//				this.origInfo.add(ci);
//				//reset the valueString for next readline()
//				valueString = "";
//			}
//
//			br.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	public void findAllCourses() {
		if (origInfo.size() == 0) {
			System.out.println("Sorry, no data was stored.");
			return;
		}
//		System.out.println("Course ID\tCourse Name\tCourse Requirment \tTime \t Location");
		for (int i=0; i<origInfo.size(); i++) {
			ClassInformation s = origInfo.get(i);
			System.out.println("    " + s.getCouseID() + "\t         " + s.getCourseName() + "\t         " + s.getCourseTeacher() + 
					"\t   " + s.getCoursetime()+ "\t         " + s.getCourseLocation());
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
			for (int i=0; i<tempInfo.size(); i++) {
				ClassInformation s = tempInfo.get(i);
				if (s.getCouseID().equals(id)) {
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
		System.out.println("Please enter course Name");
		Scanner sc1 = new Scanner(System.in);
		String name = sc1.nextLine();
		System.out.println("Please enter course Teacher Requirement");
		Scanner sc2 = new Scanner(System.in);
		String teacherreq = sc2.nextLine();
		System.out.println("Please enter course Time");
		Scanner sc3 = new Scanner(System.in);
		String location = sc3.nextLine();
		System.out.println("Please enter course Location");
		Scanner sc4 = new Scanner(System.in);
		String time = sc3.nextLine();
		
		ClassInformation ci = new ClassInformation();
		ci.setCouseID(id);
		ci.setCourseName(name);
		ci.setCourseTeacher(teacherreq);
		ci.setCoursetime(time);
		ci.setCourseLocation(location);
		
		origInfo.add(ci);
		tempInfo.add(ci);
		saveCoursesInfoTofile();
		System.out.println("Add Successful!");
	}
	
	public void deleteCourse() throws IOException {
		System.out.println("Please enter the Course ID you want to delete:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		boolean hasDelete = false;
		for (int i=0; i<tempInfo.size(); i++) {
			ClassInformation ci = tempInfo.get(i);
			if (ci.getCouseID().equals(id)) {
				tempInfo.remove(i);
				hasDelete = true;
				break;
			}
		}
		saveCoursesInfoTofile();
		if (hasDelete)
			System.out.println("Course deleted!");
		else 
			System.out.println("Course not found!");
	}
	
	public void updateCourse() throws IOException {
		System.out.println("Please enter the course ID which need update:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int index = -1;
		for (int i=0; i<tempInfo.size(); i++) {
			ClassInformation s = tempInfo.get(i);
			if (s.getCouseID().equals(id)) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("Coures not found!");
		}
		else {
			ClassInformation ci = tempInfo.get(index);
			System.out.println("Please enter course Name");
			Scanner sc1 = new Scanner(System.in);
			String name = sc1.nextLine();
			System.out.println("Please enter course Teacher Requirement");
			Scanner sc2 = new Scanner(System.in);
			String teacherreq = sc2.nextLine();
			System.out.println("Please enter course time");
			Scanner sc3 = new Scanner(System.in);
			String location = sc3.nextLine();
			System.out.println("Please enter course location");
			Scanner sc4 = new Scanner(System.in);
			String time = sc3.nextLine();
			ci.setCouseID(id);
			ci.setCourseName(name);
			ci.setCourseTeacher(teacherreq);
			ci.setCoursetime(time);
			ci.setCourseLocation(location);
			System.out.println("Updated successful");
		}
		saveCoursesInfoTofile();
	}
	
	public void saveCoursesInfoTofile() throws IOException {
		BufferedWriter bw = null;
		String destFile = "./Teaching Requests.txt";
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
			for (int i = 0; i<tempInfo.size(); i++) {
				data.append(tempInfo.get(i).getCouseID());
				data.append("," + tempInfo.get(i).getCourseName());
				data.append("," + tempInfo.get(i).getCourseTeacher());
				data.append("," + tempInfo.get(i).getCoursetime());
				data.append("," + tempInfo.get(i).getCourseLocation());
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
 
	public  void getCourseInfo() throws FileNotFoundException {
		String path = "./Teaching Requests.txt";
		LineNumberReader br = null;
		ArrayList<ClassInformation> arr = new ArrayList<ClassInformation>();
		File file = new File(path);
		String CoursesInfo = "";
		String TeacherInfo="";
		try {
			if (file.exists()) {
				FileInputStream fileInputStream = new FileInputStream(path);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
				br = new LineNumberReader(inputStreamReader);
				String infoData = null;
				while ((infoData = br.readLine()) != null) {
					if(br.getLineNumber()<15) {
					CoursesInfo += infoData;
					CoursesInfo += "\n";
//				System.out.println("----------" + CoursesInfo);
					}else {
						TeacherInfo += infoData;
						TeacherInfo +="\n";
					}
				}
				br.close();
				String[] infoArr = CoursesInfo.split("\n");
//				System.out.println(infoArr.length);
				for (int i=0; i<infoArr.length; i++) {
					String[] stuArr = infoArr[i].split(",");
//					System.out.println(stuArr.length);
					if (stuArr.length>0 ) {
						ClassInformation ci = new ClassInformation();
						ci.setCouseID(stuArr[0]);
//						System.out.println(ci.getCouseID());
						ci.setCourseName(stuArr[1]);
//						System.out.println(ci.getCourseName());
						ci.setCourseTeacher(stuArr[2]);
						ci.setCoursetime(stuArr[3]);
						ci.setCourseLocation(stuArr[4]);
						origInfo.add(ci);
						tempInfo.add(ci);
					}

//					System.out.println(stuArr);
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
//		return arr;
	}
}
//	public void addInfo(String filePath,String content) {
//
//		String str =new String(); //Original contents of the file
//		String newContent=new String(); //Updated contents
//
//		try {
//			File write = new File(filePath);
//			if (write.exists()) {
//				System.out.println("The file exist.");
//			} else {
//				System.out.println("There is no file.");
//				write.createNewFile();
//			}
//			BufferedReader br = new BufferedReader(new FileReader(write));
//
//			while ((str = br.readLine()) != null) {
//				newContent += str + "\n";
//			}
//			System.out.println(newContent);
//			br.close();
//			newContent += content;
//			BufferedWriter bw = new BufferedWriter(new FileWriter(write));
//			bw.write(newContent);
//			bw.close();
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//	
//	public static void delete(String oldStr,String filePath){
//        try {
//            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
//            String line;
//            while (null!=(line=raf.readLine())) {
//                if(line.contains(oldStr)){
//                    String[] split = line.split(oldStr);
//                    raf.seek(split[0].length());
//                    raf.writeBytes(null);
//                    raf.writeBytes(split[1]);
//                }
//            }
//           raf.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    
//	}

