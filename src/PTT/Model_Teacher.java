package PTT;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Model_Teacher {
	private ArrayList<Model_TeacherList> teacherArrayList;
	private ArrayList<Model_TeacherAndClass> teachersAndClasses; 
	String filePath;
	private int lecturerIndex;
//	private int lecturerIndex2;
	private int courseIndex1;
	private int courseIndex2;
	boolean twoCourseAvailable = false;
//	private boolean added= false;
//	private int firstAddCounter;
	
	public Model_Teacher(String filePath) {
		teacherArrayList = new ArrayList<Model_TeacherList>();
		teachersAndClasses = new ArrayList<Model_TeacherAndClass>();
		this.filePath = filePath;
		lecturerIndex = 0;
//		lecturerIndex2 = 0;
		courseIndex1 = 0;
		courseIndex2 = 0;
//		firstAddCounter = 0;
	}
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
	public ArrayList<Model_TeacherList> getTeacherArrayList() {
		return teacherArrayList;
	}


	public void setTeacherArrayList(ArrayList<Model_TeacherList> teacherArrayList) {
		this.teacherArrayList = teacherArrayList;
	}


	public ArrayList<Model_TeacherAndClass> getTeachersAndClasses() {
		return teachersAndClasses;
	}


	public void setTeachersAndClasses(ArrayList<Model_TeacherAndClass> teachersAndClasses) {
		this.teachersAndClasses = teachersAndClasses;
	}


	public void getTeacherList(Model_ClassDirector classDirector) {
		teacherArrayList.removeAll(teacherArrayList);
		Model_TeacherList s = new Model_TeacherList();
		if (classDirector.getTeacherInitalList().size() == 0) {
			System.err.println("\n" + "NO DATA!");
			return;
		}
		for (int i = 0; i < classDirector.getTeacherInitalList().size(); i++) {
			s = classDirector.getTeacherInitalList().get(i);
			System.out.println(s.getLecturerID() + "    " + s.getLecturerName()
			+ "    " + s.getDegree() + "    " + s.getMainCourse()
			+ "    " + s.getOtherCourseTeaching());
			
			teacherArrayList.add(s);
		}
		
	}
	
	
	public void matchTheCourse(Model_ClassDirector course) {
		teachersAndClasses.removeAll(teachersAndClasses);
		Model_TeacherAndClass list = new Model_TeacherAndClass();
		list.setCouseID("CoureseID");
		list.setCourseName("CourseName");
		list.setCourseTeacherReq("Requirement");
		list.setLecturerIDWithDegree("lecturer");
		teachersAndClasses.add(list);
		
		if (course.getClassTeachingRequirements().size()>0 && teacherArrayList.size()>0) {
			int counter = 0;
			
//			Model_TeacherAndClass list = new Model_TeacherAndClass();
			for (int i = 0; i < teacherArrayList.size(); i++) {
				
				for (int j = 0; j < course.getClassTeachingRequirements().size(); j++) {
					if (teacherArrayList.get(i).getMainCourse().equals(course.getClassTeachingRequirements().get(j).getCourseName())
						|| teacherArrayList.get(i).getOtherCourseTeaching().equals(course.getClassTeachingRequirements().get(j).getCourseName())) {
						
						counter++;
						lecturerIndex = i;
						if (counter  == 2) {
							courseIndex2 = j;
							twoCourseAvailable = true;
						}else {
							courseIndex1 = j;
						}
//						firstAddCounter++;
						addToTeachingList(course);
					}
					counter = 0;
					
				}
			}
		}else {
			System.err.println("No Course Data, Please Login Class Director First" + "\n" 
								+ "Then Get The Teacher List!");
		}
		
	}
	
	public void addToTeachingList(Model_ClassDirector course) {
		
		Model_TeacherAndClass list = new Model_TeacherAndClass();
		
		if (twoCourseAvailable) {
			list.setCouseID(course.getClassTeachingRequirements().get(courseIndex2).getCouseID());
			list.setCourseName(course.getClassTeachingRequirements().get(courseIndex2).getCourseName());
			list.setCourseTeacherReq(course.getClassTeachingRequirements().get(courseIndex2).getCourseTeacherReq());
			list.setLecturerIDWithDegree(teacherArrayList.get(lecturerIndex).getLecturerID() + " ("+teacherArrayList.get(lecturerIndex).getDegree()+ ")");
			teachersAndClasses.add(list);
			twoCourseAvailable = false;
		}else {
			list.setCouseID(course.getClassTeachingRequirements().get(courseIndex1).getCouseID());
			list.setCourseName(course.getClassTeachingRequirements().get(courseIndex1).getCourseName());
			list.setCourseTeacherReq(course.getClassTeachingRequirements().get(courseIndex1).getCourseTeacherReq());
			list.setLecturerIDWithDegree(teacherArrayList.get(lecturerIndex).getLecturerID() + " ("+teacherArrayList.get(lecturerIndex).getDegree()+ ")");
			teachersAndClasses.add(list);
		}
	
	}
	
	
	public void showMatchResults() {
		if (teachersAndClasses.size() == 0) {
			System.err.println("Failed Showing Matching Results!");
		}
		
		for (int i = 0; i < teachersAndClasses.size(); i++) {
			Model_TeacherAndClass list = teachersAndClasses.get(i);
			System.out.println(list.getCouseID() +  "\t" + list.getCourseName() +  "\t"
					+ list.getCourseTeacherReq() +  "\t" + list.getLecturerIDWithDegree());
		}
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
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
				StringBuilder data = new StringBuilder();
				
				for (int i = 0; i < teachersAndClasses.size(); i++) {
					data.append(teachersAndClasses.get(i).getCouseID());
					data.append("\t" + teachersAndClasses.get(i).getCourseName());
					data.append("\t" + teachersAndClasses.get(i).getCourseTeacherReq());
					data.append("\t" + teachersAndClasses.get(i).getLecturerIDWithDegree());
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
	
	
	
	public void readFile() {
		
	}
	
	
//	public void printTeacherList() {
//		if (teacherArrayList.size() == 0) {
//			System.err.println("\n" + "NO DATA!");
//			return;
//		}
//		for (int i = 0; i < teacherArrayList.size(); i++) {
//			Model_TeacherList s = teacherArrayList.get(i);
//			System.out.println("    " + s.getLecturerID() + "\t         " + s.getLecturerName()
//								+ "\t         " + s.getDegree() + "\t         " + s.getMainCourse()
//								+ "\t         " + s.getOtherCourseTeaching());
//		}
//	}
	
	
	
	
//	ArrayList<Teacher>teachers=new ArrayList<Teacher>();
//	ArrayList<Course>courses=new ArrayList<Course>();
//	
//	ArrayList<String> tryNfill=new ArrayList<String>();
//	private Object outputPath;
//	FileWriter fileWriter = new FileWriter((String) outputPath,true);	
//	
//	
//	private static ArrayList<String> matchClass(ArrayList<Teacher>teachers, ArrayList<Course>courses){
//		ArrayList matchClass = new ArrayList<String>();
//		for(int i=0;i<teachers.size();i++) {
//			Teacher o=teachers.get(i);
//			if(courses.contains(o)) {
//				matchClass.add(o);
//			}
//		}
//		return matchClass;
//		System.out.println(matchClass);
//	}
//	

	
}



