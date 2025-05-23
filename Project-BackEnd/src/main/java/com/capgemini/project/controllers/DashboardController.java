package com.capgemini.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.project.dto.DashboardCardsDTO;
import com.capgemini.project.services.DashboradService;

@RequestMapping("/api/dashboard")
@RestController
public class DashboardController {

	DashboradService service;

	@Autowired
	public DashboardController(DashboradService service) {
		this.service = service;
	}
	
	@GetMapping("/card")
	public ResponseEntity<DashboardCardsDTO> getCardData() {
		return ResponseEntity.status(HttpStatus.OK).body(service.cardData());
	}
	
	@GetMapping("/coursesPerInstructor")
	public ResponseEntity<List<Object[]>> coursesPerInstructor() {
		return ResponseEntity.status(HttpStatus.OK).body(service.coursesPerInstructor());
	}
	
	@GetMapping("/studentsPerInstructor")
	public ResponseEntity<List<Object[]>> studentsPerInstructor() {
		return ResponseEntity.status(HttpStatus.OK).body(service.studentsPerInstructor());	
	}
	
}
