package classdirector;

public class ClassInformation {
	private String couseID;
	private String courseName;
	private String courseTeacherReq;
	private String coursetime;
	private String courseLocation;

	// This map is a categories map stores category and value for each card
//	private LinkedHashMap<String, String> courseMap = new LinkedHashMap<String, String>();

	// Constructor
	public ClassInformation() {

	}

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

	public String getCourseTeacher() {
		return courseTeacherReq;
	}

	// This method set the information at each turn.
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacherReq = courseTeacher;
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
	

//	public LinkedHashMap<String, String> getCourse() {
//		return courseMap;
//	}
//	//This method will set the course inforamtion for each class
//	public void giveValue(String key, String value) {
//		this.courseMap.put(key, value);
//	}

//	public String getCourseInfoValue() {
//		// find the target value of the course
//		for (String key : courseMap.keySet()) {
//
//			if (key.equals(this.courseInfo)) {
//
//				return courseMap.get(key);
//			}
//		}
//		return null;
//	}



//	@Override
//	public String toString() {
//		String result = "";
//
//		for (String key : courseMap.keySet()) {
//
//			String value = courseMap.get(key);
//
//			result += "> " + key + ": " + value + "\n";
//		}
//		return result;
//	}
//
//	public String classDetail() {
//		String output = "";
//
//		output += this.courseName;
//
//		for (String key : courseMap.keySet()) {
//
//			String value = courseMap.get(key);
////			System.out.println("\n");
//			output += "," + value;
//
//		}
//		return output;
//	}


}
