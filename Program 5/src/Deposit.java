/**
 * Abstract Class: Deposit
 * Keeps track of holders of the deposit account and keeps track of balance and times money was taken also adds new accounts
 * @author Stavro Gorou
 * @date 3/25/20
 * CS 108 Section 1
 */



public abstract class Deposit implements Account{
	int accountID;
	public Customer holder1;
	public Customer holder2;
	int accountBalance;
	int numOfWithdrawls;
	
	public Deposit() {
		accountID = Bank.numOfAccounts;
		Bank.numOfAccounts++;
		
		holder1 = checkCustomer();
		
		accountBalance = 0;
		numOfWithdrawls = 0;
		
		System.out.println("A new account was created with account ID: " + accountID);
		System.out.println("The first holder is: " + holder1.toString());
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public void setAccountID(int newID) {
		accountID = newID;
	}
	
	public int getBalance() {
		return accountBalance;
	}
	
	public void setBalance(int newBalance) {
		accountBalance = newBalance;
	}
	
	public int getWithdrawls() {
		return numOfWithdrawls;
	}
	
	public void setWithdrawls(int newWithdrawls) {
		numOfWithdrawls = newWithdrawls;
	}
	
	public Customer getFirstHolder() {
		return holder1;
	}
	
	public void setFirstHolder(Customer newHolder) {
		holder1 = newHolder;
	}
	
	public Customer getSecondHolder() {
		return holder2;
	}
	
	public void setSecondHolder(Customer newHolder) {
		holder2 = newHolder;
	}
	
	public boolean depositMoney(int toDeposit) {
		if (toDeposit >= 0) {
			accountBalance += toDeposit;
			System.out.println("Updated Balance: " + accountBalance);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Customer checkCustomer() {
		Customer customer = null;
		
		System.out.println("Are you an existing customer? [Y: Yes; N: No]");
		
		String answer = BankApp.scan.next();
		
		if (answer.toUpperCase().equals("Y")) {
			System.out.println("Enter Customer ID:");
			int searchID = BankApp.scan.nextInt();
			
			for(int i = 0; i < BankApp.customerList.size(); i++) {
				if (BankApp.customerList.get(i).getCustomerID() == searchID) {
					return BankApp.customerList.get(i);
				}
			}
			
			System.out.println("There was no record of the ID. A new ID will be created");
			return createNewAccount(customer);
		}
		else {
			return createNewAccount(customer);
		}
	}
	
	public Customer createNewAccount(Customer customer) {
		System.out.println("Enter your name:");
		String name = BankApp.scan.next();
		if (BankApp.scan.hasNext() && !(BankApp.scan.hasNextInt())) {
			name +=  BankApp.scan.next();
		}
		
		if (name.length() <= 0) {
			customer = new Customer();
			BankApp.customerList.add(customer);
			return customer;
		}
		else {
			customer = new Customer(name);
			BankApp.customerList.add(customer);
			return customer;
		}
	}

	@Override
	public boolean addAccountHolder() {
		// TODO Auto-generated method stub
		holder2 = checkCustomer();
		System.out.println("For Account ID: " + accountID);
		System.out.println("First Holder: " + holder1.toString());
		System.out.println("Second Holder: " + holder2.toString());
		return true;
	}

	@Override
	public boolean updateAccount(Customer cust) {
		// TODO Auto-generated method stub
		holder1 = cust;
		return true;
	}

	@Override
	public boolean updateAccount(Customer cust, int ID) {
		// TODO Auto-generated method stub
		if (ID == 1) {
			holder1 = cust;
			return true;
		}
		else if (ID == 2) {
			holder2 = cust;
			return true;
		}
		
		return false;
	}

	@Override
	public int deleteAccount() {
		// TODO Auto-generated method stub
		System.out.println("Are you sure you want to delete your account?");
		
		String response = BankApp.scan.next();
		
		if (response.toUpperCase().equals("Y")) {
			System.out.println("Enter your Customer ID:");
			int customerID = BankApp.scan.nextInt();
			
			for (int i = 0; i < BankApp.depositList.size(); i++ ) {
				if (BankApp.depositList.get(i).holder1.getCustomerID() == customerID) {
					System.out.println("Do you want to delete your savings account with AccID: " + customerID + " ?");
					
					String confirmation = BankApp.scan.next();
					if (confirmation.toUpperCase().equals("Y")) {
						BankApp.depositList.remove(i);
					}
					else {
						System.out.println("Customer ID Invalid");
					}
				}
				else {
					System.out.println("Customer ID Invalid");
				}
			}
		}
		else {
			System.out.println("No accounts were deleted");
		}
		return 0;
	}
	
	public void resetWithdrawls() {
		numOfWithdrawls = 0;
	}
	
	public abstract boolean withDrawMoney(int amount);
	public abstract int calcInterest();
	public abstract boolean addInterest();
}



