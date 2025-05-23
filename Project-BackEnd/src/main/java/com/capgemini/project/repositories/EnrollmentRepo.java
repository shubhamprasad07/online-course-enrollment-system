package com.capgemini.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.project.entities.Enrollment;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long>{

	@Query("SELECT COUNT(e) FROM Enrollment e")
	public long countEnrollment();
	
	@Query(value = "SELECT c.title FROM course c JOIN enrollment e ON c.course_id = e.courseid GROUP BY c.title ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
	public String bestSellerCourse();
	
	@Query("SELECT i.name,COUNT(e) FROM Course c" + 
			" JOIN Enrollment e ON c.courseId = e.courseID" + 
			" JOIN Instructor i on i.instructorID = c.instructorId" + 
			" GROUP BY i.name")
	public List<Object[]> studentsPerInstructor();
	
}
