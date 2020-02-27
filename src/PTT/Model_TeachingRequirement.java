package PTT;

//import java.util.LinkedHashMap;

public class Model_TeachingRequirement {
//	private LinkedHashMap<String, String> teachingRequirment = new LinkedHashMap<String, String>();
//	private String course;
	private String couseID;
	private String courseName;
	private String courseTeacherReq;
	private String coursetime;
	private String courseLocation;
	
	
	public String getCouseID() {
		return couseID;
	}
	public void setCouseID(String couseID) {
		this.couseID = couseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTeacherReq() {
		return courseTeacherReq;
	}
	public void setCourseTeacherReq(String courseTeacherReq) {
		this.courseTeacherReq = courseTeacherReq;
	}
	public String getCoursetime() {
		return coursetime;
	}
	public void setCoursetime(String coursetime) {
		this.coursetime = coursetime;
	}
	public String getCourseLocation() {
		return courseLocation;
	}
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	
	
	
//	public String getCourse() {
//		return course;
//	}
//
//	public void setCourse(String course) {
//		this.course = course;
//	}

//	public LinkedHashMap<String, String> getTeachingRequirment() {
//		return teachingRequirment;
//	}
//	
//	public void setTeachingRequirement(String key, String value) {
//		this.teachingRequirment.put(key, value);
//	}
//	
	
	
//	@Override
//	public String toString() {
//		String print = "";
//		
//		for (String key : teachingRequirment.keySet()) {
//			String value = teachingRequirment.get(key);
//			print += "> " + key + ": " + value + "\n";
//		}
//		return print;
//	}
//	
//	
//	
//	public String teachingRequirementDetails() {
//		String printDetails = "";
//		printDetails += this.course;
//		
//		for (String key : teachingRequirment.keySet()) {
//			String value = teachingRequirment.get(key);
//			printDetails += "," + value;
//		}
//		return printDetails;
//	}

}	



