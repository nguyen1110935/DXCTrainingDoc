package com.dxc.demo.junit;

import org.junit.Test;
import static org.junit.Assert.*;

import com.dxc.demo.model.Book;


public class BookTest {
	
	@Test
	public void checkTitle() {
		String message = "Hi There!";
		Book book = new Book(message);
		assertEquals("Checking book initialization", message, book.getTitle());
	}
}
