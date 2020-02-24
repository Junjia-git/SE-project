package classdirector;

public class ClassInformation {
	private String teacher;
	private String couseTime;
	private String location;
	
	public ClassInformation(){
		
	}

	public String getTeacher() {
		return teacher;
	}

	public String getCouseTime() {
		return couseTime;
	}

	public String getLocation() {
		return location;
	}
	public String getInformation() {
		String information=couseTime +"\n"+ location + "\n"+ teacher;
		return information;
	}
	
}
