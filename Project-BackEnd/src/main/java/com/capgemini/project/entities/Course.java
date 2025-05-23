package com.capgemini.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long courseId;

	@NotBlank(message = "Course Title Can't be Empty")
	@Size(min = 3, message = "Title must be greater than 3 characters")
	protected String title;

	@NotBlank(message = "Course Description Can't be Empty")
	@Size(min = 3, message = "Description must be greater than 3 characters")
	protected String description;

	@NotNull(message = "Instructor ID Can't be Empty")
	protected Long instructorId;

	public Course() {
	}

	public Course(Long courseId, String title, String description, Long instructorId) {
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.instructorId = instructorId;
	}

	public Course(String title, String description, Long instructorId) {
		this.title = title;
		this.description = description;
		this.instructorId = instructorId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}

	@Override
	public String toString() {
		return "courseId=" + courseId + ", title=" + title + ", description=" + description + ", instructorID="
				+ instructorId;
	}

}
