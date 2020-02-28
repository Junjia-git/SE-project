package PTT;


import java.io.BufferedOutputStream;
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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.Cipher;

import org.junit.runner.manipulation.Sortable;


public class Model_ClassDirector {
	private ArrayList<Model_TeachingRequirement> classTeachingRequirements;
	private ArrayList<Model_TeachingRequirement> initalList;
	private ArrayList<Model_TeacherList> teacherInitalList;
	private int courseCounter = 0;
	private boolean added = false;
	private boolean removed = false;
	private int removeID = 0;
//	private ArrayList<String> addList;
//	private ArrayList<String> removeList;
//	private int addCounter;
//	private int removeCounter;
	String filePath;
	
	public Model_ClassDirector(String filePath) {
		classTeachingRequirements = new ArrayList<Model_TeachingRequirement>();
		initalList = new ArrayList<Model_TeachingRequirement>();
		teacherInitalList = new ArrayList<Model_TeacherList>();
//		addList = new ArrayList<String>();
//		removeList = new ArrayList<String>();
		this.filePath = filePath;
//		getTeachingRequirement(filePath);
//		addCounter = 0;
//		removeCounter = 0;
	}

	public ArrayList<Model_TeachingRequirement> getClassTeachingRequirements() {
		return classTeachingRequirements;
	}
	
	public ArrayList<Model_TeachingRequirement> getInitalList() {
		return initalList;
	}
	
	

//	public ArrayList<String> getAddList() {
//		return addList;
//	}
//
//	public ArrayList<String> getRemoveList() {
//		return removeList;
//	}
//	
//
//	public int getAddCounter() {
//		return addCounter;
//	}
//
//	public int getRemoveCounter() {
//		return removeCounter;
//	}
//	
//
//	public void setAddCounter(int addCounter) {
//		this.addCounter = addCounter;
//	}
//
//	public void setRemoveCounter(int removeCounter) {
//		this.removeCounter = removeCounter;
//	}
	
	
//	public void getTeachingInfo() throws FileNotFoundException{
//		File file = new File(filePath);
//		LineNumberReader lineReader = null;
//		String courseString = "";
//		try {
//			lineReader = new LineNumberReader(new FileReader(file));
//			while((courseString = lineReader.readLine()) != null) {
//				initalList.add(courseString);
//				if (lineReader.getLineNumber() == 8) {
//					break;
//				}
//			}
//			
//			for (String i : initalList) {
//				System.out.println(i + "\n" + "\t");
//
//			}
//
//			
//			
//			
//			
//			Model_TeachingRequirement title = new Model_TeachingRequirement();
////			title.setCouseID(couseID);
//		} catch (Exception e) {
//		}
//	}

	
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
	}
	
	public void resetTeacherInfo() {
		teacherInitalList.removeAll(teacherInitalList);
	}

	public void getCourseInfo()throws FileNotFoundException{
		resetCourseInfo();
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
					if (lineReader.getLineNumber() >=19) {
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
					}
				}
				
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
					teacherList += infoData;
					teacherList += "\n";
					if (lineReader.getLineNumber() == 18) {
						break;
					}
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
			System.out.println("Sorry, no data was stored.");
			return;
		}
//		System.out.println("Course ID\tCourse Name\tCourse TeacherRequ \tCourse Time \tCourse Location");
		for (int i=0; i<classTeachingRequirements.size(); i++) {
			Model_TeachingRequirement s = classTeachingRequirements.get(i);
			System.out.println(s.getCouseID() + "    " + s.getCourseName() + "     " 
			+ s.getCourseTeacherReq() + "    " + s.getCoursetime() + "    " + s.getCourseLocation());
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
		String location = sc3.nextLine();
//		sc3.close();
		
		System.out.println("Please enter course Location");
		Scanner sc4 = new Scanner(System.in);
		String time = sc3.nextLine();
//		sc4.close();
		Model_TeachingRequirement course = new Model_TeachingRequirement();
		course.setCouseID(id);
		course.setCourseName(name);
		course.setCourseTeacherReq(teacherreq);
		course.setCoursetime(time);
		course.setCourseLocation(location);
		
		initalList.add(course);
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
//				delToFile();
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
			System.out.println("Course not found!");
	}
					

//	public void delToFile() {
		
		

//		File src = new File(filePath);
//		String removeString = classTeachingRequirements.get(removeID).getCouseID();
////		System.out.println(removeString);
//		
//		Model_TeachingRequirement s = classTeachingRequirements.get(removeID);
//		String oldChar = s.getCouseID() + "    " + s.getCourseName() + "     " 
//						+ s.getCourseTeacherReq() + "    " + s.getCoursetime() + "    " + s.getCourseLocation();
//		String newChar = "";
//		
//		if (removed) {
//			try {
//				if (src.exists()) {
//					FileInputStream fileInputStream = new FileInputStream(src);
//					InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
//					LineNumberReader lineReader = new LineNumberReader(inputStreamReader);
////					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"));
//					PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
//					
//					String infoData = null;
//					while ((infoData = lineReader.readLine()) != null) {
//						if (lineReader.getLineNumber() >=19) {
//							if (infoData.contains(removeString)) {
////								StringBuffer buf = new StringBuffer();
//								writer.println(infoData.replace(oldChar, newChar));
////								System.out.println(infoData);
//							}
//						}
//						}
//					writer.close();
//					lineReader.close();
//				}
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			}	
//		}else {
//			System.err.println("No data deleted!");
//		}
//		
//	}
			
		
//		saveCoursesInfoTofile();
//		try {
//         RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
//            String line;
//            while (null!=(line=raf.readLine())) {
//            
//                if(line.contains(classTeachingRequirements.get(removeID).getCouseID())){
//                    String[] split = line.split(classTeachingRequirements.get(removeID).getCouseID());
//                    raf.seek(split[0].length());
//                    raf.writeBytes("");
//                    raf.writeBytes(split[1]);
//                }
////                System.out.println(line);
//                line = "";
//            }
//           raf.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
	
	
	public void updateCourse() throws IOException {
		System.out.println("Please enter the course ID which need update:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
//		sc.close();
		int index = -1;
		for (int i=0; i<classTeachingRequirements.size(); i++) {
			Model_TeachingRequirement s = classTeachingRequirements.get(i);
			if (s.getCouseID().equals(id)) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("Coures not found!");
		}
		else {
			
			System.out.println("Please enter course Name");
			Scanner sc1 = new Scanner(System.in);
			String name = sc1.nextLine();
//			sc1.close();
			
			System.out.println("Please enter course Teacher Requirement");
			Scanner sc2 = new Scanner(System.in);
			String teacherreq = sc2.nextLine();
//			sc2.close();
			
			System.out.println("Please enter course time");
			Scanner sc3 = new Scanner(System.in);
			String location = sc3.nextLine();
//			sc3.close();
			
			System.out.println("Please enter course location");
			Scanner sc4 = new Scanner(System.in);
			String time = sc3.nextLine();
//			sc4.close();
			
			Model_TeachingRequirement course = new Model_TeachingRequirement();
			course.setCouseID(id);
			course.setCourseName(name);
			course.setCourseTeacherReq(teacherreq);
			course.setCoursetime(time);
			course.setCourseLocation(location);
			System.out.println("Updated successful");
		}
		saveCoursesInfoTofile();
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

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
			StringBuilder data = new StringBuilder();
//			data.append(course.getCouseID());
//			data.append("\t" + course.getCourseName());
//			data.append("\t" + course.getCourseTeacherReq());
//			data.append("\t" + course.getCoursetime());
//			data.append("\t" + course.getCourseLocation());
//			data.append("\n");
			if (added) {
			int c = courseCounter-1;
			System.out.println(courseCounter);
//				data.append("\n");
				data.append("\r\n");
				data.append(classTeachingRequirements.get(c).getCouseID());
				data.append("\t" + classTeachingRequirements.get(c).getCourseName());
				data.append("\t" + classTeachingRequirements.get(c).getCourseTeacherReq());
				data.append("\t" + classTeachingRequirements.get(c).getCoursetime());
				data.append("\t" + classTeachingRequirements.get(c).getCourseLocation());
				added = false;
				writer.write(data.toString());
			}
			
			Model_TeachingRequirement s = classTeachingRequirements.get(removeID);
			String oldChar = s.getCouseID() + "\t"  + s.getCourseName() + "\t" 
					+ s.getCourseTeacherReq() + "\t" + s.getCoursetime() + "\t"  + s.getCourseLocation();
			String newChar = "";
			
			if (removed) {
				CharArrayWriter  tempStream = new CharArrayWriter();  
		        // 替换  
		        String line = null;  
		        while ( (line = bufIn.readLine()) != null) {  
		            // 替换每行中, 符合条件的字符串  
		            line = line.replaceAll(oldChar, newChar);  
		            // 将该行写入内存  
		            tempStream.write(line);  
		            // 添加换行符  
		            tempStream.append(System.getProperty("line.separator"));  
		        }  
				
		        bufIn.close();
		        
		        FileWriter out = new FileWriter(file);  
		        tempStream.writeTo(out);  
		        out.close(); 
					removed = false;
				}
				
			
//			for (int i = 0; i<classTeachingRequirements.size(); i++) {
//				data.append(classTeachingRequirements.get(i).getCouseID());
//				data.append("\t" + classTeachingRequirements.get(i).getCourseName());
//				data.append("\t" + classTeachingRequirements.get(i).getCourseTeacherReq());
//				data.append("\t" + classTeachingRequirements.get(i).getCoursetime());
//				data.append("\t" + classTeachingRequirements.get(i).getCourseLocation());
//				data.append("\n");
//			}
//			System.out.println(data);
			
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
	
//	public void getTeachingRequirement(String filePath) {
//		File src = new File(filePath);
//		LineNumberReader reader = null;
//		try {
//			reader = new LineNumberReader(new FileReader(src));
//			String firstLine = reader.readLine();
//			String[] descriptionArray = firstLine.split(" "); //descriptionArray[0] are Course/Needs/Time/Location
//			
//			String valueString = null;
//			while((valueString = reader.readLine()) != null) {
//				String[] valueArray = valueString.split(" ");
//				Model_TeachingRequirement requirement = new Model_TeachingRequirement();
//				
//				for (int i = 0; i < valueArray.length; i++) {
//					if (i == 0) {
//						//When i = 0, valueArray stores the name of the course
//						requirement.setCourse(valueArray[0]);
//					}else {
//						//When i != 0, valueArray stores Needs/Time/Location and their value
//						String key = descriptionArray[i];
//						String value = valueArray[i];
//						
//						//Put the key and value to the teaching requirement map
//						requirement.setTeachingRequirement(key, value);
//					}
//				}
//				//Add the requirement into the teaching requirement array list.
//				this.initalList.add(requirement);
//				
//				//Only scan the teaching requirement
//				if (reader.getLineNumber() == 8) {
//					break;
//				}
//				//Reset the valueString for the next readLine()
//				valueString = "";
//			}
//		} catch (Exception e) {
//           System.err.println("File not found");
//        } 
//        
//	}
//	
//	public void classDirectorList() {
//		for (int i = 0; i < initalList.size(); i++) {
//			classTeachingRequirements.add(initalList.get(i));
//			System.out.println(classTeachingRequirements.get(i));
//		}
//	}
//		
//	public void withoutEdit() {
//		for (int i = 0; i < classTeachingRequirements.size(); i++) {
//			System.out.println(classTeachingRequirements.get(i));
//		}
//	}
//	
//	public void writeNewRequirement(String filepath, String content) {
//		String str = new String(); //Original content of the file
//		String newContent = new String(); //Updated content
//		try {
//			File file = new File(filepath);
//			if (file.exists()) {
//				System.out.println("The file exists.");
//			}else {
//				System.out.println("There is no such file.");
//				file.createNewFile();
//			}
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			while((str = br.readLine()) != null) {
//				newContent += str + "\n";
//				addList.add(newContent);
//			}
//			System.out.println(newContent);
//			br.close();
//			newContent += content;
//			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//			bw.write(newContent);
//			bw.close();
//		}
////		catch (FileNotFoundException e) {
////			e.printStackTrace();
////		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//	public void addListMethod() {
//		for (int i = 0; i < classTeachingRequirements.size(); i++) {
//			classTeachingRequirements.add(addList.get(i));
//			System.out.println(classTeachingRequirements.get(i));
//		}
//	}
//	
//	public void removeRequirement() {
//		
//	}
//	
//	public void removeListMethod() {
//		for (int i = 0; i < classTeachingRequirements.size(); i++) {
//			classTeachingRequirements.add(removeList.get(i));
//			System.out.println(classTeachingRequirements.get(i));
//		}
//	}
//	

}
