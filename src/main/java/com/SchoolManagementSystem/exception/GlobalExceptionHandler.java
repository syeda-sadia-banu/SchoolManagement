package com.SchoolManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TeacherNotFoundException.class)
	public ResponseEntity<String> handleTeacherNotFoundException(TeacherNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseNotFoundexception.class)
	public ResponseEntity<String> handleCourseNotFoundException(CourseNotFoundexception ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
