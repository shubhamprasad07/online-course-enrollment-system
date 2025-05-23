package com.capgemini.project.services;

import java.util.List;

import com.capgemini.project.entities.Instructor;

public interface InstructorService {

	public List<Instructor> listAllInstructor();
	
	public void deleteInstructor(Long id);
	
	public Instructor createInstructor(Instructor ins);
	
	public Instructor findInstructorById(Long id);
	
	public Instructor updateInstructor(Long id, Instructor ins);
	
	public Instructor patchInstructor(Long id, Instructor ins);
	
	public long countInstructor();
}
