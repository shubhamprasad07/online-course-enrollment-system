package com.capgemini.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.project.dto.DashboardCardsDTO;
import com.capgemini.project.repositories.CourseRepo;
import com.capgemini.project.repositories.EnrollmentRepo;
import com.capgemini.project.repositories.InstructorRepo;
import com.capgemini.project.repositories.UserRepo;

@Service
public class DashboradServiceImp implements DashboradService{
	
	CourseRepo courseRepo;
	EnrollmentRepo enrollmentRepo;
	InstructorRepo instructorRepo;
	UserRepo userRepo;
	
	@Autowired
	public DashboradServiceImp(CourseRepo courseRepo, EnrollmentRepo enrollmentRepo, InstructorRepo instructorRepo,
			UserRepo userRepo) {
		this.courseRepo = courseRepo;
		this.enrollmentRepo = enrollmentRepo;
		this.instructorRepo = instructorRepo;
		this.userRepo = userRepo;
	}

	@Override
	public DashboardCardsDTO cardData() {
		
		DashboardCardsDTO card = new DashboardCardsDTO();
		card.setCourseCount(courseRepo.countCourse());
		card.setBestSellerText(enrollmentRepo.bestSellerCourse());
		card.setEnrollmentCount(enrollmentRepo.countEnrollment());
		card.setInstructorCount(instructorRepo.countInstructor());
		card.setStudentCount(userRepo.userCount("student"));
		return card;
	}
	
	@Override
	public List<Object[]> coursesPerInstructor() {
		return courseRepo.coursesPerInstructor();
	}
	
	@Override
	public List<Object[]> studentsPerInstructor() {
		return enrollmentRepo.studentsPerInstructor();
	}
}
