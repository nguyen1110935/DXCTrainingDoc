package com.dxc.test.origin;

/**
 * Fee Calculation in an investment bank
 * @author hle71
 *
 */
public class FeeCalculation {
	
	/**
	 * calculates fees and bonuses for brokers who sell a certain kind of investment account
to their corporate clients.
	 * @param accounts
	 * @return
	 */
	float calculateFee(Account accounts[]) {
		float totalFee = 0;
		Account account;
		for (int i = 0; i < accounts.length; i++) {
			account = accounts[i];
			if (account.accountType == Account.PREMIUM || account.accountType == Account.PREMIUM_PLUS) {
				totalFee += 0.0125 * (account.principal * Math.exp(account.rate * (account.daysActive / 365.25))
						- account.principal);
			}
		}
		return totalFee;
	}
	
}
