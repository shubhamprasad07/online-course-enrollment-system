package com.capgemini.project.dto;

public class StudentPerCourseDTO {
	
	protected String courseTitle;
	protected long studentCount;

	public StudentPerCourseDTO(String courseTitle, long studentCount) {
		this.courseTitle = courseTitle;
		this.studentCount = studentCount;
	}

	public StudentPerCourseDTO() {
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public long getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(long studentCount) {
		this.studentCount = studentCount;
	}

}
