package PTT;

import java.io.IOException;

public class PTTCMLApplication {
	public static void main(String[] args) throws IOException{
//		String filePath = ("/Users/guodongyang/eclipse-workspace/SE_AssessedExercise/Teaching Requests.txt");
		String filePath="./Teaching Requests.txt";
		Model_ClassDirector mc = new Model_ClassDirector(filePath);
		Model_Teacher mt = new Model_Teacher(filePath);
		Model_Administrator ma = new Model_Administrator(filePath);
		Model_PTTDirector mp = new Model_PTTDirector(filePath);
		View_CommandLine vc = new View_CommandLine();
		
		Controller c = new Controller(mc, mt, ma, mp, vc);
	
		c.startRunning(filePath);
	}

	
}
