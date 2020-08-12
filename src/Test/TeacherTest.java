package Test;

import java.io.FileNotFoundException;

import PTT.*;

public class TeacherTest {

	public static void main(String[] args) throws FileNotFoundException {
		String filePath="./Teaching Requests.txt";
		Model_Teacher mt =new Model_Teacher(filePath);
		Model_ClassDirector cd=new Model_ClassDirector(filePath);
		cd.getCourseInfo();
		cd.getTeacherInfo();
		mt.getTeacherList(cd);
		mt.getTeachersAndClasses();
		mt.matchTheCourse(cd);
		mt.writeToFile();
	}

}
