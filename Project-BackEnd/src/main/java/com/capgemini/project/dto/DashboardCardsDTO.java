package com.capgemini.project.dto;

public class DashboardCardsDTO {
	
	long studentCount;
	long courseCount;
	long instructorCount;
	long enrollmentCount;
	String bestSellerText;
	
	public DashboardCardsDTO() {
	}
	
	public DashboardCardsDTO(int studentCount, int courseCount, int instructorCount, int enrollmentCount,
			String bestSellerText) {
		this.studentCount = studentCount;
		this.courseCount = courseCount;
		this.instructorCount = instructorCount;
		this.enrollmentCount = enrollmentCount;
		this.bestSellerText = bestSellerText;
	}

	public long getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(long studentCount) {
		this.studentCount = studentCount;
	}

	public long getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(long courseCount) {
		this.courseCount = courseCount;
	}

	public long getInstructorCount() {
		return instructorCount;
	}

	public void setInstructorCount(long instructorCount) {
		this.instructorCount = instructorCount;
	}

	public long getEnrollmentCount() {
		return enrollmentCount;
	}

	public void setEnrollmentCount(long enrollmentCount) {
		this.enrollmentCount = enrollmentCount;
	}

	public String getBestSellerText() {
		return bestSellerText;
	}

	public void setBestSellerText(String bestSellerText) {
		this.bestSellerText = bestSellerText;
	}
		
}
