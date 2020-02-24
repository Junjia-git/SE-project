package PTT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Controller {
	private Model_ClassDirector mc;
	private Model_Teacher mt;
	private Model_Administrator ma;
	private Model_PTTDirector mp;
	private View_CommandLine vc;

//	int lineNumber;
	
	public Controller(Model_ClassDirector mc, Model_Teacher mt, Model_Administrator ma, Model_PTTDirector mp, View_CommandLine vc) {
		this.mc = mc;
		this.mt = mt;
		this.ma = ma;
		this.mp = mp;
		this.vc = vc;
		
	}
	
	public void roleMenu() {
		vc.userChoice();
		if (vc.getUserSelection().userSelectionListener() == 1) {
			vc.classDirectorView(mc);
			
		}
		
		if (vc.getUserSelection().userSelectionListener() == 2) {
			
		}
		
	}
	
	
	

}
