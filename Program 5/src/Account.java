/**
 * Interface: Account
 * An interface for all accounts in the program
 * @author Stavro Gorou
 * @date 3/25/20
 * CS 108 Section 1
 */

 interface Account {
	 public boolean addAccountHolder();
	 
	 public boolean updateAccount(Customer cust);
	 
	 public boolean updateAccount(Customer cust, int ID);
	 
	 public int deleteAccount();
	 
	 public int getAccountID();
}
