package classdirector;

public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassDirector cd=new ClassDirector();
		String filePath = "./Teaching Requests.txt";
//		cd.sendRequest(filePath);
		String content = "Lecturer";
		cd.writeRequest(filePath, content);
	}

}
