package com.dxc.demo.junit.advance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class ExceptionTest {
	
	@Test(expected = FileNotFoundException.class)
	public void testReadFile() throws IOException { 
	    FileReader reader = new FileReader("test.txt"); 
	    reader.read(); 
	    reader.close();
	} 

}
