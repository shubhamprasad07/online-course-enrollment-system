package com.capgemini.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.project.entities.Instructor;
import com.capgemini.project.exceptions.InstructorNotFoundException;
import com.capgemini.project.repositories.InstructorRepo;

@Service
public class InstructorServiceImp implements InstructorService {

	private final InstructorRepo repo;

	@Autowired
	public InstructorServiceImp(InstructorRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Instructor> listAllInstructor() {
		return repo.findAll();
	}

	@Override
	public void deleteInstructor(Long id) {
		if (!(repo.existsById(id))) {
			throw new InstructorNotFoundException("Can't Delete. Instructor not found with ID: " + id);
		}

		repo.deleteById(id);
	}

	@Override
	public Instructor createInstructor(Instructor ins) {
		return repo.save(ins);
	}

	@Override
	public Instructor findInstructorById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new InstructorNotFoundException("Instructor not found with ID: " + id));

	}

	@Override
	public Instructor updateInstructor(Long id, Instructor ins) {
		Instructor newInstructor = repo.findById(id)
				.orElseThrow(() -> new InstructorNotFoundException("Instructor not found with ID: " + id));
		newInstructor.setExpertise(ins.getExpertise());
		newInstructor.setName(ins.getName());
		repo.save(newInstructor);
		return newInstructor;
	}

	@Override
	public Instructor patchInstructor(Long id, Instructor ins) {
		Instructor newInstructor = repo.findById(id)
				.orElseThrow(() -> new InstructorNotFoundException("Instructor not found with ID: " + id));
		if(ins.getExpertise() != null) {			
			newInstructor.setExpertise(ins.getExpertise());
		}
		
		if(ins.getName() != null) {			
			newInstructor.setName(ins.getName());
		}
		return repo.save(newInstructor);
	}
	
	@Override
	public long countInstructor() {
		return repo.countInstructor();
	}

}
