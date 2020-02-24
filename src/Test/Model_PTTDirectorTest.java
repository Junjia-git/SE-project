package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import PTT.Model_PTTDirector;

public class Model_PTTDirectorTest {
	Model_PTTDirector mp;
	
	
	public Model_PTTDirectorTest() {
		mp = new Model_PTTDirector();
	}
	
	@Test
	public void readTest() {
		mp.readTeachingRequests();
	}

}
