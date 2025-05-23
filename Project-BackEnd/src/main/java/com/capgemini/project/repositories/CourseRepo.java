package com.capgemini.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.project.entities.Course;


@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
	
	@Query("SELECT COUNT(c) FROM Course c")
	public long countCourse();
	
	@Query(value = "SELECT c.title, COUNT(e.enrollmentid) FROM course c JOIN enrollment e ON e.courseid = c.course_id GROUP BY c.title", nativeQuery = true)
	public List<Object[]> studentPerCourse();
	
	@Query("SELECT i.name, COUNT(c) from Course c Join Instructor i ON c.instructorId = i.instructorID GROUP BY i.name")
	public List<Object[]> coursesPerInstructor();
	
}
