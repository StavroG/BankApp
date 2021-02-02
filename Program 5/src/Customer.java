/**
 * Concrete Class: Customer
 * Keeps track of how many customers there are and adds new ones when needed
 * @author Stavro Gorou
 * @date 3/25/20
 * CS 108 Section 1
 */

public class Customer {
	final int customerID;
	String customerName;
	int customerAccounts;
	
	public Customer() {
		customerID = Bank.numOfCustomers;
		Bank.numOfCustomers++;
		customerName = "Customer" + customerID;
		customerAccounts = 0;
	}
	
	public Customer(String name) {
		customerID = Bank.numOfCustomers;
		Bank.numOfCustomers++;
		customerName = name;
		customerAccounts = 0;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String newName) {
		customerName = newName;
	}
	
	public int getCustomerAccounts() {
		return customerAccounts;
	}
	
	public void setCustomerAccounts(int numOfAccs) {
		customerAccounts = numOfAccs;
	}
	
	public String toString() {
		return "Customer: " + customerName + " | " + "Customer ID: " + customerID;
	}
}
