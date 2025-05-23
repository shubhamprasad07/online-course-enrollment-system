package com.capgemini.project.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InstructorNotFoundException extends RuntimeException{
	public InstructorNotFoundException(String message) {
		super(message);
	}
}

