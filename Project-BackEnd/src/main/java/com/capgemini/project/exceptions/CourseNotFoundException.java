package com.capgemini.project.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CourseNotFoundException extends RuntimeException{
	public CourseNotFoundException(String message) {
		super(message);
	}
}
