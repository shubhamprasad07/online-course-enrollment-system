package com.capgemini.project.services;

import java.util.List;

import com.capgemini.project.entities.Course;

public interface CourseService {

	public List<Course> listAllCourse();
	
	public void deleteCourse(Long id);
	
	public Course createCourse(Course course);
	
	public Course findCourseById(Long id);
	
	public Course updateCourse(Long id, Course course);
	
	public Course patchCourse(Long id, Course course);
	
	public long countCourse();
	
	public List<Object[]> studentPerCourse();
	
}
