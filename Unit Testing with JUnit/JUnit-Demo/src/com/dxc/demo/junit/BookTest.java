package com.dxc.demo.junit;

import org.junit.Test;
import static org.junit.Assert.*;

import com.dxc.demo.model.Book;


public class BookTest {
	
	@Test
	public void checkTitle() {
		// Given / Setup
		String message = "Hi There!";
		Book book = new Book(message);
		
		// When / Do action
		book.upperCaseTitle();
		
		// Then / Verify result
		assertEquals("Checking book initialization", "Hi There!".toUpperCase(), book.getTitle());
	}
	
	@Test
	public void testFailed() {
		// Given / Setup
		String message = "Hi There!";
		Book book = new Book(message);
		
		// When / Do action
		book.upperCaseTitle();
		
		// Then / Verify result
		assertNotEquals("Checking book initialization", "Hi There!", book.getTitle());
	}
}
