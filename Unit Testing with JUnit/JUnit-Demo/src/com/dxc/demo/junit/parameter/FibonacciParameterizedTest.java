package com.dxc.demo.junit.parameter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciParameterizedTest {

	private Fibonacci fib = new Fibonacci(); // one class instance per test
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }  
           });
    }
    
    @Parameter // first data value (0) is default
    public int input; /* NOT private */

    @Parameter(1)
    public int expected; /* NOT private */
	
	@Test
	public void testCompute() {
		assertEquals(expected, fib.compute(input));
	}
}
