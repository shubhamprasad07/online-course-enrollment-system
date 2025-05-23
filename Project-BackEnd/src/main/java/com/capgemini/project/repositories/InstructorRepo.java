package com.capgemini.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.project.entities.Instructor;


@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long>{
	
	@Query("SELECT COUNT(i) FROM Instructor i")
	public long countInstructor();
}
