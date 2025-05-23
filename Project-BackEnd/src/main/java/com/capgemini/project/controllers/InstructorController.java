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

import com.capgemini.project.entities.Instructor;
import com.capgemini.project.services.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
	private final InstructorService service;

	public InstructorController(InstructorService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Instructor>> getAllInstructor() {
		List<Instructor> instructors = service.listAllInstructor();
		return ResponseEntity.status(HttpStatus.OK).body(instructors);
	}
	

	@GetMapping("/count")
	public ResponseEntity<Long> getUserCount() {
		return ResponseEntity.status(HttpStatus.OK).body(service.countInstructor());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable("id") long id) {
		Instructor instructor = service.findInstructorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(instructor);
	}

	@PostMapping
	public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
		Instructor saved = service.createInstructor(instructor);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
		Instructor updated = service.updateInstructor(id, instructor);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Instructor> patchInstructor(@PathVariable Long id, @RequestBody Instructor patch) {
		Instructor updated = service.patchInstructor(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
		service.deleteInstructor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
