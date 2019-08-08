package com.dxc.demo.junit;

import java.util.List;

public interface CourseRegistrationDAO {
	
	List<Course> findCoursesByStudent(Student student);
	
	void addCourseForStudent(Student student, Course course);
	
//	void withdrawCourseFromStudent(Student student, Course course);
}
