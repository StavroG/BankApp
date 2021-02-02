/**
 * Concrete Class: Deposit
 * Extention of deposit class that has interest and can withdraw money from the account
 * @author Stavro Gorou
 * @date 3/25/20
 * CS 108 Section 1
 */

public class Savings extends Deposit{
	final int interest = 4;
	
	public Savings() {
		super();
	}

	@Override
	public boolean withDrawMoney(int amount) {
		// TODO Auto-generated method stub
		if (super.numOfWithdrawls < 3) {
			if (super.accountBalance > amount) {
				super.accountBalance -= amount;
				super.numOfWithdrawls++;
				System.out.println("Updated Balance: " + super.accountBalance);
				System.out.println("Remaining Withdrawals: " + (3 - super.numOfWithdrawls));
				return true;
			}
			
			if (super.accountBalance < amount) {
				System.out.println("Not Enough Balance");
			}
			
			if (super.accountBalance == 0) {
				System.out.println("Invalid Amount");
			}	
			    return false;
		}
		else {
			System.out.println("Withdrawals Limit Exceeded");
			return false;
		}
		
	}

	@Override
	public int calcInterest() {
		// TODO Auto-generated method stub
		int monthlyInterest = (int)Math.floor(super.accountBalance * ((double) interest / 100) / 12);
		
		return monthlyInterest;
	}

	@Override
	public boolean addInterest() {
		// TODO Auto-generated method stub
		if (BankApp.bank.isMonthEnd) {
			super.accountBalance += calcInterest();
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Savings | Balance: " + super.accountBalance + " | Withdrawals: " + super.numOfWithdrawls + " | Potential Interest: " + calcInterest();
	}
	
}
