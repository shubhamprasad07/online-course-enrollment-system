package com.capgemini.project.services;

import java.util.List;

import com.capgemini.project.dto.DashboardCardsDTO;

public interface DashboradService {
	
	DashboardCardsDTO cardData();
	
	List<Object[]> coursesPerInstructor();
	
	List<Object[]> studentsPerInstructor();

}
