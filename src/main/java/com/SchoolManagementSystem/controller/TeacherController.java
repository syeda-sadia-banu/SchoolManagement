package com.SchoolManagementSystem.controller;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagementSystem.model.Courses;
import com.SchoolManagementSystem.model.Teacher;
import com.SchoolManagementSystem.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@GetMapping("/getTeachers")
	private List<Teacher> getAllTeacher() {
		return teacherService.getAllTeachers();

	}

	@GetMapping("/getTeacher/{id}")
	private Optional<Teacher> getTeacherById(@PathVariable int teacherId) {
		return teacherService.getTeachersById(teacherId);
	}

	@PostMapping("/teacher")
	private Teacher createTeacher(@RequestBody Teacher teacher) {
		
		return teacherService.createTeacher(teacher);
	}

	@PutMapping("/updatingTeacher/{id}")
	private Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher updateTeacher) {
		return teacherService.updateTeacher(id, updateTeacher);
	}

	@DeleteMapping("/delete/{id}")
	private String deleteTeacher(@PathVariable int id) {
		teacherService.deleteTeacher(id);
		return " Teacher data deleted successfully";
	}

	@PostMapping("/assigncourse")
	public Teacher assignCourseToTeacher(@RequestParam int teacherId, @RequestParam int courseId) {
		return teacherService.assignCourseToTeacher(teacherId, courseId);
	}

	@GetMapping("/teacher/{teacherId}/courses")
	public List<Courses> getCourseByTeacher(@PathVariable int teacherId) {
		return teacherService.getCoursesByTeacher(teacherId);
	}

	@GetMapping("/course/{id}/teacher")
	public List<Teacher> getTeacherByCourse(@PathVariable int courseId) {
		return teacherService.getTeacherByCourse(courseId);
	}
	@DeleteMapping("/remove")
	public String deleteCourseForTeacher(@RequestParam int teacherId, @RequestParam int courseId) {
		teacherService.removeCourseFromTeacher(teacherId, courseId);
		return "removed course"+ courseId +" for "+teacherId;
		
	}

}
