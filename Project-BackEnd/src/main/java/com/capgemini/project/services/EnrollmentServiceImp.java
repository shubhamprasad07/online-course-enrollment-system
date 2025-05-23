package com.capgemini.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.project.entities.Enrollment;
import com.capgemini.project.exceptions.EnrollmentNotFoundException;
import com.capgemini.project.repositories.EnrollmentRepo;

@Service
public class EnrollmentServiceImp implements EnrollmentService {

	private final EnrollmentRepo repo;

	public EnrollmentServiceImp(EnrollmentRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Enrollment> listAllEnrollment() {
		return repo.findAll();
	}

	@Override
	public boolean deleteEnrollment(Long id) {
		if (!(repo.existsById(id))) {
			throw new EnrollmentNotFoundException("Can't Delete. Enrollment not found with ID: " + id);
		}
		repo.deleteById(id);
		return true;
	}

	@Override
	public Enrollment createEnrollment(Enrollment enrollment) {
		return repo.save(enrollment);
	}

	@Override
	public Enrollment findEnrollmentById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found with ID: " + id));
	}

	@Override
	public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
		Enrollment existing = repo.findById(id)
				.orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found with ID: " + id));
		existing.setEnrollmentDate(enrollment.getEnrollmentDate());
		existing.setCourseID(enrollment.getCourseID());
		existing.setUserID(enrollment.getUserID());
		return repo.save(existing);
	}

	@Override
	public Enrollment patchEnrollment(Long id, Enrollment enrollment) {
		Enrollment existing = repo.findById(id)
				.orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found with ID: " + id));
		if(enrollment.getEnrollmentDate() != null) {			
			existing.setEnrollmentDate(enrollment.getEnrollmentDate());
		}
		if(enrollment.getCourseID() != 0) {			
			existing.setCourseID(enrollment.getCourseID());
		}
		if (enrollment.getUserID() != 0) {			
			existing.setUserID(enrollment.getUserID());
		}
		return repo.save(existing);
	}
	
	@Override
	public long countEnrollment() {
		return repo.countEnrollment();
	}
	
	@Override
	public String bestSellerCourse() {
		return repo.bestSellerCourse();
	}

}
