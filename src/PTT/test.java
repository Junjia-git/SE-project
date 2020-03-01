package PTT;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="./Teaching Requests.txt";
		Model_Teacher mt=new Model_Teacher(filePath);
		mt.showMatchResults();
	}

}
