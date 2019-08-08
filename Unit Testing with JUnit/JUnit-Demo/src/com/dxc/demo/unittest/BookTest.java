package com.dxc.demo.unittest;

import com.dxc.demo.model.Book;

public class BookTest extends UnitTest {

	@Override
	public void runTest() throws Exception {
		Book book = new Book("Tom&Jerry");
		assertTrue(book.getTitle().equals("Tom&Jerry"), "Checking book initialization");
	}

}
