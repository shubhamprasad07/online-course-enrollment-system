package com.capgemini.project.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.project.exceptions.UserAlreadyExistsException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	private Map<String, Object> createErrorDetails(String message, HttpStatus status) {
	    Map<String, Object> errorDetails = new HashMap<>();
	    errorDetails.put("timestamp", LocalDateTime.now());
	    errorDetails.put("message", message);
	    errorDetails.put("status", status.value());
	    return errorDetails;
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}


	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> handleCourseNotFound(CourseNotFoundException ex){
		return new ResponseEntity<>(createErrorDetails(ex.getMessage(),HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {
		return new ResponseEntity<>(createErrorDetails(ex.getMessage(),HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InstructorNotFoundException.class)
	public ResponseEntity<Object> handleInstructorNotFound(InstructorNotFoundException ex) {
		return new ResponseEntity<>(createErrorDetails(ex.getMessage(),HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EnrollmentNotFoundException.class)
	public ResponseEntity<Object> handleEnrollmentNotFound(EnrollmentNotFoundException ex) {
		return new ResponseEntity<>(createErrorDetails(ex.getMessage(),HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("status", status.value());

		Map<String, String> fieldErrors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));

		errorDetails.put("errors", fieldErrors);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex) {
		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", "Unexpected error occurred");
		errorDetails.put("details", ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
