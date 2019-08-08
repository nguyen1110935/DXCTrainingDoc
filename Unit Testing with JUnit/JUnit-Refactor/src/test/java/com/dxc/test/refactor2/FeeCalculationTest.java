package com.dxc.test.refactor2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FeeCalculationTest {

	public FeeCalculation feeCalculation;
	
	@Before
	public void init() {
		feeCalculation = new FeeCalculation();
	}
	
	@Test
	public void testTypicalResults() {
		Account accounts[] = new Account[3];
		accounts[0] = new Account(35, (float) 0.04, 365, Account.Type.PREMIUM);
		accounts[1] = new Account(100, (float) 0.035, 100, Account.Type.BUDGET);
		accounts[2] = new Account(50, (float) 0.04, 600, Account.Type.PREMIUM_PLUS);
		
		float result = feeCalculation.calculateFee(accounts);
		assertEquals(result, (float) 0.060289, (float) 0.00001);
	}

	@Test
	public void testNonPremiumAccounts() {
		Account accounts[] = new Account[2];
		accounts[0] = new Account(12, (float) 0.025, 100, Account.Type.BUDGET);
		accounts[1] = new Account(50, (float) 0.0265, 150, Account.Type.STANDARD);
		
		float result = feeCalculation.calculateFee(accounts);
		assertEquals(result, 0, (float) 0.0001);
	}
	
	// boundary conditions
	@Test
	public void testZeroRate() {
		Account accounts[] = new Account[1];
		accounts[0] = new Account(1000, (float) 0.0, 100, Account.Type.PREMIUM);
		
		float result = feeCalculation.calculateFee(accounts);
		assertEquals(result, 0, (float) 0.0001);
	}
	
	@Test
	public void testNegativePrincipal() { // not make sense
		Account accounts[] = new Account[1];
		accounts[0] = new Account(-10000, (float) 0.263, 100, Account.Type.PREMIUM);
		
		float result = feeCalculation.calculateFee(accounts);
		assertEquals(result, -9.33265, (float) 0.0001);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullInput() {
		Account accounts[] = null;
		
		float result = feeCalculation.calculateFee(accounts);
		fail(); // should not reach here
	}
}
