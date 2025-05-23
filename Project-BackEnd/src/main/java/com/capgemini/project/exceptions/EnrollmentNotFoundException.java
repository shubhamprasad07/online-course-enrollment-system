package com.capgemini.project.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EnrollmentNotFoundException extends RuntimeException{
	public EnrollmentNotFoundException(String message) {
		super(message);
	}
}
