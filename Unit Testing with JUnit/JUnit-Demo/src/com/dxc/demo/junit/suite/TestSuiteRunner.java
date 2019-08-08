package com.dxc.demo.junit.suite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(FirstTestSuite.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}
		
		System.out.println("Number of Success: " + (result.getRunCount() - result.getFailureCount()));
	}
}
