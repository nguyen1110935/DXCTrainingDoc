package com.dxc.test.refactor2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
	float principal;// the original sum of money borrowed in a loan or put into an investment
	float rate;		// an annual interest rate - 10.8% ~ 0.108
	int daysActive;	// the number of days that the account was active
//	int accountType;
	Type accountType;
	
//	public static final int STANDARD = 0;
//	public static final int BUDGET = 1;
//	public static final int PREMIUM = 2;
//	public static final int PREMIUM_PLUS = 3;
	
	public enum Type {
		STANDARD, BUDGET, PREMIUM, PREMIUM_PLUS
	}
	
	boolean isPremium() {
//		return accountType == PREMIUM || accountType == PREMIUM_PLUS;
		return accountType == Type.PREMIUM || accountType == Type.PREMIUM_PLUS;
	}
	
	float interestEarned() {
		float yearsActive = daysActive / (float) 365.25;
		float compoundInterest = principal * (float) Math.exp(rate * yearsActive);
		return compoundInterest - principal;
	}
}
