package com.dxc.test.refactor1;

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
			
			// + accountType: the brokers only earn a fee for premium accounts, which could either be of the type PREMIUM or PREMIUM_PLUS
			if (account.accountType == Account.PREMIUM || account.accountType == Account.PREMIUM_PLUS) {
				// a compound interest calculation to figure out how much interest was earned on the account
				// + 0.0125: each broker earned a commission fee that was equal to 1.25% of the interest earned on the account
				// + / 365.25: in the Account class "daysActive" represented the number of days that the account was active, but the "rate" was an annual interest rate, so they had to divide "daysActive" by 365.25 to convert it to years
				// + - account.principal: the fee calculation was based only on the interest earned, regardless of the principal that was initially put into the account
				totalFee += 0.0125 * (account.principal * Math.exp(account.rate * (account.daysActive / 365.25))
						- account.principal);
			}
		}
		return totalFee;
	}
	
}
