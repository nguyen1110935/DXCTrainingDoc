package com.dxc.demo.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.dxc.demo.junit.BookTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BookTest.class
})
public class FirstTestSuite {

}
