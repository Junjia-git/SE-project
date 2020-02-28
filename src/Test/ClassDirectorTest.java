package Test;


import java.io.IOException;

import org.junit.Test;

import PTT.Controller;
import PTT.Model_Administrator;
import PTT.Model_ClassDirector;
import PTT.Model_PTTDirector;
import PTT.Model_Teacher;
import PTT.Model_TeacherList;
import PTT.Model_TeachingRequirement;
import PTT.View_CommandLine;
import PTT.View_UserSelection;

public class ClassDirectorTest {
	Model_ClassDirector mc;
	Model_Teacher mt;
	Model_Administrator ma;
	Model_PTTDirector mp;
	View_CommandLine vc;
	View_UserSelection vu;
	Controller c;
	Model_TeacherList mtl;
	Model_TeachingRequirement mtr;
	String filePath = "/Users/guodongyang/eclipse-workspace/SE_AssessedExercise/Teaching Requests.txt";
	
	public ClassDirectorTest() {
		mc = new Model_ClassDirector(filePath);
		mt = new Model_Teacher(filePath);
		ma = new Model_Administrator();
		mp = new Model_PTTDirector(filePath);
		vc = new View_CommandLine();
		mtl = new Model_TeacherList();
		mtr = new Model_TeachingRequirement();
		c = new Controller(mc, mt, ma, mp, vc, mtl, mtr);
	}
	
	@Test
	public void test() throws IOException {
		c.startRunning(filePath);
	}

}
