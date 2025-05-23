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

import com.capgemini.project.entities.Course;
import com.capgemini.project.services.CourseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

	private final CourseService service;

	public CourseController(CourseService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Course>> getAllourse() {
		List<Course> courses = service.listAllCourse();
		return ResponseEntity.status(HttpStatus.OK).body(courses);
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getUserCount() {
		return ResponseEntity.status(HttpStatus.OK).body(service.countCourse());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getoCourseById(@PathVariable("id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findCourseById(id));
	}
	
	@GetMapping("/studentPerCourse")
	public ResponseEntity<List<Object[]>> studentPerCourse() {
		return ResponseEntity.status(HttpStatus.OK).body(service.studentPerCourse());
	}

	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course saved = service.createCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/courses/" + saved.getCourseId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
		Course updated = service.updateCourse(id, course);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Course> patchCourse(@PathVariable Long id, @RequestBody Course patch) {
		Course updated = service.patchCourse(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		service.deleteCourse(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
