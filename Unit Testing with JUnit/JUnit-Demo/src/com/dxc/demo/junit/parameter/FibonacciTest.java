package com.dxc.demo.junit.parameter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FibonacciTest {

	private Fibonacci fib = new Fibonacci();
	
	@Test
	public void testCompute() {
		assertEquals(0, fib.compute(0));
		assertEquals(1, fib.compute(1));
		assertEquals(1, fib.compute(2));
		assertEquals(2, fib.compute(3));
		assertEquals(3, fib.compute(4));
		assertEquals(5, fib.compute(5));
		assertEquals(8, fib.compute(6));
	}
}
