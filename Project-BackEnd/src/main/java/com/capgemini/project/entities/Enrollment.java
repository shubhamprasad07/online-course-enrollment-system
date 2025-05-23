package com.capgemini.project.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long enrollmentID;
	
	@NotNull(message = "User ID Number Can't be Empty")
	protected long userID;
	
	@NotNull(message = "Course ID Number Can't be Empty")
	protected long courseID;
	
	@NotNull(message = "Enrollment Date Number Can't be Empty")
	protected Date enrollmentDate;

	public Enrollment() {
	}

	public Enrollment(long enrollmentID, long userID, long courseID, Date enrollmentDate) {
		this.enrollmentID = enrollmentID;
		this.userID = userID;
		this.courseID = courseID;
		this.enrollmentDate = enrollmentDate;
	}

	public Enrollment(long userID, long courseID, Date enrollmentDate) {
		this.userID = userID;
		this.courseID = courseID;
		this.enrollmentDate = enrollmentDate;
	}

	public long getEnrollmentID() {
		return enrollmentID;
	}

	public void setEnrollmentID(long enrollmentID) {
		this.enrollmentID = enrollmentID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	@Override
	public String toString() {
		return "enrollmentID=" + enrollmentID + ", userID=" + userID + ", courseID=" + courseID
				+ ", enrollmentDate=" + enrollmentDate;
	}
	
	
	
}
