package classdirector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClassDirector {


	// Constructor
	public ClassDirector() {
//		String filePath = "./Teaching Requests.txt";
//		sendRequest(filePath);
//		writeRequest(filePath);
	}

	public void sendRequest(String filePath) {
		String result =new String();
		File filename = new File(filePath);
		try  {
			FileReader reader = new FileReader(filename); 
			BufferedReader br = new BufferedReader(reader);
			String line=null;
			while ((line = br.readLine()) != null) {
				result=result+line+"\r\n";
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);

	}

	public void writeRequest(String filePath,String content) {

		String str =new String(); //Original contents of the file
		String newContent=new String(); //Updated contents

		try {
			File write = new File(filePath);
			if (write.exists()) {
				System.out.println("The file exist.");
			} else {
				System.out.println("There is no file.");
				write.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(write));

			while ((str = br.readLine()) != null) {
				newContent += str + "\n";
			}
			System.out.println(newContent);
			br.close();
			newContent += content;
			BufferedWriter bw = new BufferedWriter(new FileWriter(write));
			bw.write(newContent);
			bw.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
