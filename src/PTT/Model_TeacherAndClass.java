package PTT;

public class Model_TeacherAndClass {
	private String couseID;
	private String courseName;
	private String courseTeacherReq;
	private String lecturerIDWithDegree;
	
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
	public String getLecturerIDWithDegree() {
		return lecturerIDWithDegree;
	}
	public void setLecturerIDWithDegree(String lecturerIDWithDegree) {
		this.lecturerIDWithDegree = lecturerIDWithDegree;
	}

	@Override
	public String toString() {
		String s = getCouseID() + "    " + getCourseName() + "     "
				+ getCourseTeacherReq() + "    " + getLecturerIDWithDegree();
		return s;
	}
}
