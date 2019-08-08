package com.dxc.demo.junit.advance;

import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TimeoutTest {

	@Test(timeout = 1) // 1 millisecond
	public void verifyFastZipCodeMatch() throws Exception {
		Pattern pattern = Pattern.compile("^\\d{5}([\\-]\\d{4})?$");
		Matcher matcher = pattern.matcher("22014");
		boolean isValid = matcher.matches();
		assertTrue("Pattern did not validate zip code", isValid);
	}
}
