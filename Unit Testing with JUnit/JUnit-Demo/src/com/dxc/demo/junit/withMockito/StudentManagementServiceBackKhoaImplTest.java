package com.dxc.demo.junit.withMockito;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class StudentManagementServiceBackKhoaImplTest {
	
	StudentManagementServiceBackKhoaImpl sut;
	IStudentRepositoryService repoService;
	INotificationService notiService;
	IStudentCachingService cachingService;
	
	@Before
	public void init() {
		repoService = mock(IStudentRepositoryService.class);
		notiService = mock(INotificationService.class);
		cachingService = mock(IStudentCachingService.class);
		sut = new StudentManagementServiceBackKhoaImpl(repoService, notiService, cachingService);
	}

	@Test
	public void testFindStudentByStudentID_foundStudent() {
		// Given / Setup
		String studentID = "50303416";
		List<Student> resultList = new ArrayList<>();
		Student dummy = new Student();
		dummy.setFirstName("Nguyen");
		dummy.setLastName("Van");
		dummy.setStudentID(studentID);
		resultList.add(dummy);
		
		when(repoService.searchStudent(any(Student.class))).thenReturn(resultList);
				
		// When / Execute
		Student foundStudent = sut.findStudentByStudentID(studentID);
		
		// Then / Verify
		assertEquals("Nguyen", foundStudent.getFirstName());
		assertEquals("Van", foundStudent.getLastName());
		
		verify(cachingService).putToCache(studentID, foundStudent);
	}
	
	@Test
	public void testFindStudentByStudentID_notFound() {
		// Given / Setup
		List<Student> resultList = new ArrayList<>();
		
		String studentID = "50303416";
		
		when(repoService.searchStudent(any(Student.class))).thenReturn(resultList);
				
		// When / Execute
		Student student = sut.findStudentByStudentID(studentID);
		
		// Then / Verify
		assertNull(student);
		
		verify(cachingService, never()).putToCache(studentID, student);
	}
	
	@Ignore
//	@Test(expected = RuntimeException.class)
	public void testFindStudentByStudentID_MoreThanOneStudent() {
		// Given / Setup
		String studentID = "50303416";
		List<Student> resultList = new ArrayList<>();
		Student student1 = new Student();
		student1.setFirstName("Nguyen");
		student1.setLastName("Van");
		student1.setStudentID(studentID);
		resultList.add(student1);
		
		Student student2 = new Student();
		student2.setFirstName("Toan");
		student2.setLastName("Tran");
		student2.setStudentID(studentID);
		resultList.add(student2);
		
		when(repoService.searchStudent(any(Student.class))).thenReturn(resultList);
				
		// When / Execute
		sut.findStudentByStudentID(studentID);
		
		// Then / Verify
		fail("Should not reach here.");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindStudentByStudentID_invalidStudentID() {
		// Given / Setup
		String studentID = null;
				
		// When / Execute
		sut.findStudentByStudentID(studentID);
		
		// Then / Verify
		fail("Should not reach here.");
	}
	
}
