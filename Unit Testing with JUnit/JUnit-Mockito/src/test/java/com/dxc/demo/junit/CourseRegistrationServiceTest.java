package com.dxc.demo.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CourseRegistrationServiceTest { // maximum 4 courses

	private CourseRegistrationService service;
	private Student student;
	
	@Before
	public void initialize() {
//		MockitoAnnotations.initMocks(this);
		student = new Student("Nguyen Van Nam");
		
	}
	
	@Test
	public void test() {
		// Given: I am a student
		// And I have not register any courses
		Course course = new Course("Math");
		CourseRegistrationDAO daoService = Mockito.mock(CourseRegistrationDAO.class);
		service = new CourseRegistrationService(daoService);
		Mockito.when(daoService.findCoursesByStudent(student)).thenReturn(Arrays.asList(course));
		
		// When I register a course
		List<Course> list = service.register(student, course);
		
		// Then that course is in my course list
		// And I have 1 course
		assertTrue(list.contains(course));
		Mockito.verify(daoService).addCourseForStudent(student, course);
	}

//	@Test
	public void test2() {
		// Given: I am a student
		// And I have already registered 3 courses
		
		// When I register a new course
		
		// Then there are 4 courses in my course list
	}

//	@Test
	public void test3() {
		// Given: I am a student
		// And And I have already registered 4 courses
		
		// When I register a new course
		
		// Then that course is not added to my course list
		// And I still have 4 courses
	}
	
//	@Test
	public void test4() {
		// Given: I am a student
		// And I have already registered 3 courses
		
		// When I register an existing course
		
		// Then that course is not added to my course list
		// And I still have 3 courses
	}
	
//	@Test
	public void test5() {
		// Given: I am a student
		// And I have already registered 4 courses
		
		// When I withdraw an existing course
		// And I register a new course
		
		// Then that course is in my course list
		// And I have 4 courses
	}
}
