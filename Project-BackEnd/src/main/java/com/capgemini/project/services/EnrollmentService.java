package com.capgemini.project.services;

import java.util.List;

import com.capgemini.project.entities.Enrollment;

public interface EnrollmentService {
	
	public List<Enrollment> listAllEnrollment();

	public boolean deleteEnrollment(Long id);

	public Enrollment createEnrollment(Enrollment enrollment);

	public Enrollment findEnrollmentById(Long id);

	public Enrollment updateEnrollment(Long id, Enrollment enrollment);

	public Enrollment patchEnrollment(Long id, Enrollment enrollment);
	
	public long countEnrollment();
	
	public String bestSellerCourse();
}
