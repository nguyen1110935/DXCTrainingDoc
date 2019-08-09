package com.dxc.demo.junit.withMockito;

import java.util.List;

public class StudentManagementServiceBackKhoaImpl {
	
	private IStudentRepositoryService repoService;
	private INotificationService notiService;
	private IStudentCachingService cachingService;
	
	public StudentManagementServiceBackKhoaImpl(IStudentRepositoryService repoService, INotificationService notiService,
			IStudentCachingService cachingService) {
		super();
		this.repoService = repoService;
		this.notiService = notiService;
		this.cachingService = cachingService;
	}
	
	public Student findStudentByStudentID (String studentID) {
		if (studentID == null || studentID.isEmpty()) {
			throw new IllegalArgumentException("StudentID is not valid");
		}
		
		Student student = new Student();
		student.setStudentID(studentID);
		List<Student> students = repoService.searchStudent(student);
		
		if (students == null || students.size() == 0) {
			return null; // not found
		} else {
			if (students.size() > 1) {
				throw new RuntimeException("There are more than one student with given studentID: " + studentID);
			} else {
				Student foundStudent = students.get(0);
				cachingService.putToCache(studentID, foundStudent);
				return foundStudent;
			}
		}
	}
	
}
