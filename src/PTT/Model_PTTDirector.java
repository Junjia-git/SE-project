package PTT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Model_PTTDirector {
	private ArrayList<String> results;
	private ArrayList<Model_TeacherAndClass> reqList;
	String filePath;
	private boolean approved;
	private boolean oneRoundOver;
	
	public Model_PTTDirector(String filePath) {
		results = new ArrayList<String>();
		reqList = new ArrayList<Model_TeacherAndClass>();
		this.filePath = filePath;
		oneRoundOver = false;
	}
	
	
	public boolean isOneRoundOver() {
		return oneRoundOver;
	}


	public void setOneRoundOver(boolean oneRoundOver) {
		this.oneRoundOver = oneRoundOver;
	}


	public ArrayList<String> getResults() {
		return results;
	}


	public void setResults(ArrayList<String> results) {
		this.results = results;
	}


	public ArrayList<Model_TeacherAndClass> getReqList() {
		return reqList;
	}


	public void setReqList(ArrayList<Model_TeacherAndClass> reqList) {
		this.reqList = reqList;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public void readTeachingRequests(Model_Administrator ma) {
		reqList.removeAll(reqList);
		File src = new File(filePath);
		BufferedReader br = null;
		String teachingReq = "";
		approved = false;
		
		try {
			if (src.exists()) {
				FileInputStream fileInputStream = new FileInputStream(src);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
				br = new BufferedReader(inputStreamReader);
				
				String requestsInfo = null;
				while((requestsInfo = br.readLine()) != null) {
					teachingReq += requestsInfo;
					teachingReq += "\n";
				}
				br.close();
				
				String[] rowArr = teachingReq.split("\n");
				for (int i = 0; i < rowArr.length; i++) {
					String[] columnArr = rowArr[i].split("\t",5);
					
					if (columnArr.length>0) {
						Model_TeacherAndClass list = new Model_TeacherAndClass();
						list.setCouseID(columnArr[0]);
						list.setCourseName(columnArr[1]);
						list.setCourseTeacherReq(columnArr[2]);
						list.setLecturerIDWithDegree(columnArr[3]);
						reqList.add(list);
						
					}else {
						System.err.println("Failed to read the file!");
					}
				}
				
			}else {
				System.err.println("File not found!");
			}
			
			
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public void printOutReqList() {
		if (reqList.size() == 0) {
			System.err.println("Sorry, no data in the list!");
			return;
		}
		for (int i=0; i<reqList.size(); i++) {
			Model_TeacherAndClass s = reqList.get(i);
			System.out.println(s.getCouseID() + "\t" + s.getCourseName() + "\t" 
			+ s.getCourseTeacherReq() + "\t" + s.getLecturerIDWithDegree() + "\n");
		}
	}
	
	
	
	public void approveReqList(View_UserSelection vu) {
		if (reqList.size()>0) {
			System.out.println("\n"+"Approve these teaching requests or not? " + "\n"
								+ "1 >> 	Yes" + "\n" + "2 >> 	No");
//			Scanner s = new Scanner(System.in);
//			String choice = s.nextLine();
			
				int choice = vu.userSelectionListener();
				switch (choice) {
				case 1:
					System.out.println("\n" + "-------------------------------------------------------" + "\n" 
							+ "---------THE TEACHING REQUIREMENTS ARE APPROVED--------" + "\n" 
							+ "-------------------------------------------------------" + "\n");
					
					approved = true;
//					printOutReqList();
					finalResults();
					System.out.println("\n" + "Remember to save!");
					break;
					
				case 2:
					System.err.println("\n" + "-------------------------------------------------------" + "\n"
							+ "--------THE TEACHING REQUIREMENTS ARE NOT APPROVED-----" + "\n"
							+ "-------------------------------------------------------" + "\n");
					
					approved = false;
//					printOutReqList();
					finalResults();
					System.out.println("\n" + "Remember to add comments to the Class Director and The Teacher Director");
					break;
					
				default:
					System.err.println("Undefined input! Please input again!");
					approveReqList(vu);
				}
			
			
		}else {
			System.err.println("No data found!");
		}
	}
	
	
	
	public void finalResults() {
		results.removeAll(results);
		if (approved) {
			String line1 = "-------------------------------------------------------";
			String line2 = "---------THE TEACHING REQUIREMENTS ARE APPROVED--------";
			String line3 = "-------------------------------------------------------";
			results.add(line1);
			results.add(line2);
			results.add(line3);
		}else {
			String line1 = "-------------------------------------------------------";
			String line2 = "--------THE TEACHING REQUIREMENTS ARE NOT APPROVED-----";
			String line3 = "-------------------------------------------------------";
			results.add(line1);
			results.add(line2);
			results.add(line3);
		}
		
	}
	
	
	public void addComments() {
		if (results.size()>0) {
			System.out.println("Add your comments: ");
			Scanner s = new Scanner(System.in);
			String comments = s.nextLine();
			results.add(comments);
			System.out.println("\n" + "Comments Added Successfully!");
		}else {
			System.err.println("\n" + "Have not approved yet! Please run the second step(2 > Approve or not) first!");
		}
	}
	
	
	
	public void save() {
		
		BufferedWriter writer = null;

		File file = new File(filePath);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (results.size()>0) {
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "UTF-8"));
				StringBuilder data = new StringBuilder();
				
				for (int i = 0; i < results.size(); i++) {
					data.append("\r\n");
					data.append(results.get(i));
				}
				
//				System.out.println(data);
				writer.write(data.toString());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("\n"+"File saved!");
		}else {
			System.err.println("No data to be saved!" + "\n" + "Please match the courses first!");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
