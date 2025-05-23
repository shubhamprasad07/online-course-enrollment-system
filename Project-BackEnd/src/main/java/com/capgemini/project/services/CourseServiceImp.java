package com.capgemini.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.project.entities.Course;
import com.capgemini.project.exceptions.CourseNotFoundException;
import com.capgemini.project.repositories.CourseRepo;

@Service
public class CourseServiceImp implements CourseService {

	private final CourseRepo repo;

	@Autowired
	public CourseServiceImp(CourseRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Course> listAllCourse() {
		return repo.findAll();
	}

	@Override
	public void deleteCourse(Long id) {
		if (!(repo.existsById(id))) {
			throw new CourseNotFoundException("Cannot delete. Course not found with ID: " + id);
		}
		repo.deleteById(id);
	}

	@Override
	public Course createCourse(Course course) {
		return repo.save(course);
	}

	@Override
	public Course findCourseById(Long id) {
		return repo.findById(id).orElseThrow(() -> new CourseNotFoundException("Employee not found with ID: " + id));
	}

	@Override
	public Course updateCourse(Long id, Course course) {
		Course newCourse = repo.findById(id)
				.orElseThrow(() -> new CourseNotFoundException("Employee not found with ID: " + id));
		newCourse.setDescription(course.getDescription());
		newCourse.setInstructorId(course.getInstructorId());
		newCourse.setTitle(course.getTitle());
		return repo.save(newCourse);
	}

	@Override
	public Course patchCourse(Long id, Course course) {
		Course newCourse = repo.findById(id)
				.orElseThrow(() -> new CourseNotFoundException("Employee not found with ID: " + id));
		if (course.getDescription() != null) {
			newCourse.setDescription(course.getDescription());
		}
		if (course.getInstructorId() != 0) {
			newCourse.setInstructorId(course.getInstructorId());
		}
		if (course.getTitle() != null) {
			newCourse.setTitle(course.getTitle());
		}
		return repo.save(newCourse);
	}
	
	@Override
	public long countCourse() {
		return repo.countCourse();
	}
	
	@Override
	public List<Object[]> studentPerCourse() {
		return repo.studentPerCourse();
	}

}
