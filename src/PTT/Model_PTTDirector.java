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
	private static ArrayList<String> requests;

	
	public Model_PTTDirector() {
		ma = new Model_Administrator();
		requests = new ArrayList<String>();
	}
	
	public void readTeachingRequests() {
		try {
			FileReader fr = new FileReader("/Users/guodongyang/eclipse-workspace/SE_AssessedExercise/Teaching Requests.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String readData;
			while ((readData = br.readLine())!= null) {
				try {
					requests.add(readData);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			br.close();
			fr.close();
			for (int i = 0; i < requests.size(); i++) {
				System.out.println(requests.get(i));
			}
//			System.out.println(requests.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	public void writeTeachingRequests() {
//		try {
//            FileWriter fw = new FileWriter("/Users/guodongyang/eclipse-workspace/SE_AssessedExercise/Teaching Requests.txt");
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            for(int i = 0; i<requests.size();i++){
//                bw.write(requests.get(i).toString()+"\n");
//                bw.flush();
//            }
//            bw.close();
//            fw.close();
// 
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		

}