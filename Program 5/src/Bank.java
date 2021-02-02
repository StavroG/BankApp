/**
 * Concrete Class: Bank
 * Checks the month and if it is the end of the month
 * @author Stavro Gorou	
 * @date 3/25/20
 * CS 108 Section 1
 */

public class Bank {
	static int numOfAccounts = 0;
	static int numOfCustomers = 0;
	
	int month;
	
	boolean isMonthEnd;
	
	public Bank() {
		month = 0;
		isMonthEnd = false;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int nextMonth() {
		if (isMonthEnd == false) {
			System.out.println("It is not the end of the month!");
			return -1;
		}
		
		month++;
		
		if (month > 11) {
			month = 0;
			return month;
		}
		
		isMonthEnd = false;
		return month;
	}
	
	public int endOfMonth () {
		if (isMonthEnd) {
			System.out.println("It is already the end of the month!");
			return -1;
		}
		else {
			isMonthEnd = true;
			System.out.println("It is now the end of the month");
			return month;
		}
	}
}
