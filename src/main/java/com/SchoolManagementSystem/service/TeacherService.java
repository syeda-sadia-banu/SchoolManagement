package com.SchoolManagementSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagementSystem.exception.CourseNotFoundexception;
import com.SchoolManagementSystem.exception.TeacherNotFoundException;
import com.SchoolManagementSystem.model.Courses;
import com.SchoolManagementSystem.model.Teacher;
import com.SchoolManagementSystem.repository.CourseRepository;
import com.SchoolManagementSystem.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Teacher> getAllTeachers(){
		return teacherRepository.findAll();
	}
	
	public Optional<Teacher> getTeachersById(int teacherId) {
		
		return teacherRepository.findById(teacherId);
	}
	
	public Teacher createTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
		
	}
	public Teacher updateTeacher(int id,Teacher updateTeacher) {
		return teacherRepository.save(updateTeacher);
	}
   
	public void deleteTeacher(int id) {
		teacherRepository.deleteById(id);
		
	}
	
	public Teacher assignCourseToTeacher(int teacherId, int courseId) {
        Teacher teacher = teacherRepository.findById(teacherId)
            .orElseThrow(() -> new TeacherNotFoundException("Teacher not found with id: " + teacherId));
        
        Courses course = courseRepository.findById(courseId)
            .orElseThrow(() -> new CourseNotFoundexception("Course not found with id: " + courseId));
        
        teacher.getCourses().add(course);
        teacherRepository.save(teacher);
        return teacher;
    }
	
	public List<Courses> getCoursesByTeacher(int teacherId){
		Teacher teacher=teacherRepository.findById(teacherId)
				        .orElseThrow(()->new TeacherNotFoundException("teacher not found"));
		return teacher.getCourses();
	}
	
	public List<Teacher> getTeacherByCourse(int teacherId){
		Courses course=courseRepository.findById(teacherId)
				.orElseThrow(()-> new CourseNotFoundexception("course not found"));
		return course.getTeacher();
		
	}
	
	public void removeCourseFromTeacher(int teacherId,int courseId) {
		
		Teacher teacher=teacherRepository.findById(teacherId)
				.orElseThrow(()->new TeacherNotFoundException("taecher not found"));
		Courses course=courseRepository.findById(courseId)
				.orElseThrow(()->new CourseNotFoundexception("course not found"));
		teacher.getCourses().remove(courseId);
		teacherRepository.save(teacher);
		
	}
}
