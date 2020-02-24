package PTT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Model_ClassDirector {
	private ArrayList<String> teachingRequirement;
	private ArrayList<String> tempList;
	private Model_PTTDirector mp;
	
	public Model_ClassDirector() {
		teachingRequirement = new ArrayList<String>();
		tempList = new ArrayList<String>();
		mp = new Model_PTTDirector();
	}

	public ArrayList<String> getTeachingRequirement() {
		return teachingRequirement;
	}
	
	public void getTeachingRequirement(File sourceFile) {
		LineNumberReader reader = null;
		try {
			FileReader fr = new FileReader(sourceFile);
			reader = new LineNumberReader(fr);
			String s = null;
			
			while ((s = reader.readLine()) != null) {
				tempList.add(s);
				if (reader.getLineNumber() == 32) {
					break;
				}
//				System.out.println(s);
//				System.out.println(tempList.size());
			}
		} catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	public void classDirectorList() {
		for (int i = 0; i < tempList.size(); i++) {
			teachingRequirement.add(tempList.get(i));
			System.out.println(teachingRequirement.get(i));
		}
	}
	
	public void writeNewRequirements(File sourceFile) {
		
		try {
			FileWriter fw = new FileWriter(sourceFile, true);
			BufferedWriter pw = new BufferedWriter(fw);
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Add new requirements below:");
			String newRequ = scanner.next();

			scanner.close();
			pw.write(newRequ);
			teachingRequirement.add(newRequ);
			pw.flush();
			pw.close();
			
			System.out.println("");

			for (int i = 0; i < teachingRequirement.size(); i++) {
				System.out.println(teachingRequirement.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
