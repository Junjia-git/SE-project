package PTT;

import java.io.File;
import java.io.IOException;

public class PTTCMLApplication {
	public static void main(String[] args) throws IOException{
		Model_ClassDirector mc = new Model_ClassDirector();
		Model_Teacher mt = new Model_Teacher();
		Model_Administrator ma = new Model_Administrator();
		Model_PTTDirector mp = new Model_PTTDirector();
		View_CommandLine vc = new View_CommandLine();
		Controller controller = new Controller(mc, mt, ma, mp, vc);
		
		File sourceFile = new File("/Users/guodongyang/eclipse-workspace/SE_AssessedExercise/Teaching Requests.txt");
		
		mc.getTeachingRequirement(sourceFile);
		mc.classDirectorList();
		mc.writeNewRequirements(sourceFile);	
	}

	
}
