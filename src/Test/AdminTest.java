package Test;

import java.io.FileNotFoundException;

import PTT.*;

public class AdminTest {

	public static void main(String[] args) throws FileNotFoundException{
		String filePath="./Teaching Requests.txt";
		Model_ClassDirector cd =new Model_ClassDirector(filePath);
		Model_Teacher mt = new Model_Teacher(filePath);
		Model_Administrator ma = new Model_Administrator(filePath);

		mt.getTeachersAndClasses();

		ma.readTeachingRequests();

		ma.getTeachersAndClassesList();

		ma.printOutList();

		ma.selectLecturers();
		ma.getCourseCounter();
		ma.selectView(cd);
		
	}

}
