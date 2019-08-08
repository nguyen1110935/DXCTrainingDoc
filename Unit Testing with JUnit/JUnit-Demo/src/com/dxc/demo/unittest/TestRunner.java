package com.dxc.demo.unittest;

public class TestRunner {
	public static void main(String[] args) {
		TestRunner runner = new TestRunner();
		runner.run();
	}
	
	public void run() {
		try {
			UnitTest test = new BookTest();
			test.runTest();
			System.out.println("Success");
			System.out.println("Number of Success: " + UnitTest.getNumSuccess());
		} catch (Exception ex) {
			System.out.println("Failure: " + ex.getMessage());
		}
	}
}
