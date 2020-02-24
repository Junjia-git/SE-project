package CourseManager;

 
public class Course {
	private String id;
	private String name;
	private String req;
	private String trainGourp;
	public Course() {
		
	}
	public Course(String id, String name, String req, String trainGourp) {
 
		this.id = id;
		this.name = name;
		this.req = req;
		this.trainGourp = trainGourp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	public String getTrainGourp() {
		return trainGourp;
	}
	public void setTrainGourp(String trainGourp) {
		this.trainGourp = trainGourp;
	}
}