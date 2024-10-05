package com.SchoolManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagementSystem.model.Courses;
import com.SchoolManagementSystem.service.Courseservice;

@RestController
public class CourseController {
	@Autowired
	private Courseservice courseservice;
	
	@PostMapping("/Course")
	public Courses createCourse(@RequestBody Courses course) {
		return courseservice.createCourse(course);
	}

}
