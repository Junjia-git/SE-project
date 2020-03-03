package Test;


import org.junit.Test;

import PTT.View_CommandLine;

public class View_CommandLineTest {
	View_CommandLine view;
	
	public View_CommandLineTest() {
		view = new View_CommandLine();
	}
	
	@Test
	public void test() {
		view.userLogIn();
	}

}
