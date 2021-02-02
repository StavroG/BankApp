/**
 * Concrete Class: Checking
 * Creates a checking account which is a type of deposit account
 * @author Stavro Gorou
 * @date 3/25/20
 * CS 108 Section 1
 */

public class Checking extends Deposit{

	final int interestRate = 1;
	
	public Checking() {
		super();
	}
	
	@Override
	public boolean withDrawMoney(int amount) {
		// TODO Auto-generated method stub
		
		if (super.accountBalance > amount) {
			super.accountBalance -= amount;
			System.out.println("Updated Balance: " + super.accountBalance);
			return true;
		}
		else if (super.accountBalance < amount) {
			System.out.println("Not Enough Balance");
			return false;
		}
		else {
			System.out.println("Invalid Amount");
			return false;
		}
	}

	@Override
	public int calcInterest() {
		// TODO Auto-generated method stub
		int monthlyInterest = (int)Math.floor(super.accountBalance * ((double)interestRate / 100) / 12);
		
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
		return "Checking | Balance: " + super.accountBalance + " | Withdrawals: " + super.numOfWithdrawls + " | Potential Interest: " + calcInterest();
	}
	
}
