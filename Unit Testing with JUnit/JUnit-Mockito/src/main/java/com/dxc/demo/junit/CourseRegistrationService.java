package com.dxc.demo.junit;

import java.util.List;

public class CourseRegistrationService {

	private static final int MAX_COURSE = 4;
	
	private CourseRegistrationDAO dao;

	public CourseRegistrationService(CourseRegistrationDAO dao) { // injection
		this.dao = dao;
	}
	
	public List<Course> register(Student student, Course course) {
//		List<Course> courses = dao.findCoursesByStudent(student);
		dao.addCourseForStudent(student, course);
		List<Course> courses = dao.findCoursesByStudent(student);
		return courses;
	}
	
}
