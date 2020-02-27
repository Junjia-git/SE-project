package PTT;

import java.io.IOException;
import java.util.Scanner;

public class PTTCMLApplication {
	public static void main(String[] args) throws IOException{
		String filePath = ("/Users/guodongyang/eclipse-workspace/SE_AssessedExercise/Teaching Requests.txt");
		Model_ClassDirector mc = new Model_ClassDirector(filePath);
		Model_Teacher mt = new Model_Teacher(mc);
		Model_Administrator ma = new Model_Administrator();
		Model_PTTDirector mp = new Model_PTTDirector(filePath);
		Model_TeachingRequirement mtr = new Model_TeachingRequirement();
		View_CommandLine vc = new View_CommandLine();
		
		mc.getCourseInfo();
//		Controller controller = new Controller(mc, mt, ma, mp, vc);
		
//		mc.getTeachingRequirement(sourceFile);
//		mc.classDirectorList();
//		mc.writeNewRequirements(sourceFile);
	
		
	}

	
}
