package com.capgemini.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long instructorID;

	@NotBlank(message = "Instructor Name Can't be Empty")
	@Size(min = 3, message = "Instructor Name should be greater than 3 character")
	protected String name;

	@NotBlank(message = "Instructor Expertise Can't be Empty")
	@Size(min = 3, message = "Instructor Expertise should be greater than 3 character")
	protected String expertise;

	public Instructor() {
	}

	public Instructor(Long instructorID,String name, String expertise) {
		this.instructorID = instructorID;
		this.name = name;
		this.expertise = expertise;
	}

	public Instructor(String name, String expertise) {
		this.name = name;
		this.expertise = expertise;
	}

	public Long getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(Long instructorID) {
		this.instructorID = instructorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	@Override
	public String toString() {
		return "instructorID=" + instructorID + ", name=" + name + ", expertise=" + expertise;
	}
	
	

}
