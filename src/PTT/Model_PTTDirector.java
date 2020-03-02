package PTT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Model_PTTDirector {
	Model_Administrator ma;
	private ArrayList<String> requests;
	String filePath;

	
	public Model_PTTDirector(String filePath) {
		ma = new Model_Administrator(filePath);
		requests = new ArrayList<String>();
		this.filePath = filePath;
	}
	
	public void readTeachingRequests(Model_Administrator ma) {
		
		
	}
	
	
	

}
