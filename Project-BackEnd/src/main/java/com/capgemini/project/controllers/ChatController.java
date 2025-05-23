package com.capgemini.project.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.project.entities.Course;
import com.capgemini.project.entities.Instructor;

@RestController
@RequestMapping("/auth")
public class ChatController {
	 @GetMapping("/courses")
	    public List<Course> getCourses() {
	        return List.of(
	            new Course("Java Basics", "Learn Java fundamentals", 1L),
	            new Course("Spring Boot", "Build REST APIs", 2L)
	        );
	    }

	    @GetMapping("/instructors")
	    public List<Instructor> getInstructors() {
	        return List.of(
	            new Instructor("Alice", "Java"),
	            new Instructor("Bob", "Spring Boot")
	        );
	    }
}
