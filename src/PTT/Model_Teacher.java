package PTT;
import java.util.ArrayList;

public class Model_Teacher {
	private ArrayList<Model_TeacherList> teacherArrayList;
	String filePath;
	
	public Model_Teacher(String filePath) {
		teacherArrayList = new ArrayList<Model_TeacherList>();
		this.filePath = filePath;
	}
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	public void getTeacherList(Model_ClassDirector classDirector) {
		Model_TeacherList s = new Model_TeacherList();
		if (classDirector.getTeacherInitalList().size() == 0) {
			System.err.println("\n" + "NO DATA!");
			return;
		}
		for (int i = 0; i < classDirector.getTeacherInitalList().size(); i++) {
			s = classDirector.getTeacherInitalList().get(i);
			System.out.println("    " + s.getLecturerID() + "\t         " + s.getLecturerName()
			+ "\t         " + s.getDegree() + "\t         " + s.getMainCourse()
			+ "\t         " + s.getOtherCourseTeaching());
		}
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



