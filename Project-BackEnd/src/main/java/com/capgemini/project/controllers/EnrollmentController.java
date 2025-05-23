package com.capgemini.project.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.project.entities.Enrollment;
import com.capgemini.project.services.EnrollmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

	private final EnrollmentService service;

	public EnrollmentController(EnrollmentService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Enrollment>> getAllEnrollment() {
		List<Enrollment> enrollments = service.listAllEnrollment();
		return ResponseEntity.status(HttpStatus.OK).body(enrollments);
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getUserCount() {
		return ResponseEntity.status(HttpStatus.OK).body(service.countEnrollment());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable("id") long id) {
		Enrollment enrollment = service.findEnrollmentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(enrollment);
	}
	
	@GetMapping("/bestSellingCourse")
	public ResponseEntity<String> bestSellingCourse() {
		return ResponseEntity.status(HttpStatus.OK).body(service.bestSellerCourse());
	}

	@PostMapping
	public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
		Enrollment saved = service.createEnrollment(enrollment);
		return ResponseEntity.status(HttpStatus.CREATED)
				.location(URI.create("/api/enrollments/" + saved.getEnrollmentID())).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
		Enrollment updated = service.updateEnrollment(id, enrollment);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Enrollment> patchEnrollment(@PathVariable Long id, @RequestBody Enrollment patch) {
		Enrollment updated = service.patchEnrollment(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
		service.deleteEnrollment(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
