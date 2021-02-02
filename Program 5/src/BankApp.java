/**
 * BankApp Class (Main File)
 * Calls and menu and allows a user to navigate through the functionality of the program
 * @author Stavro Gorou
 * @date 3/25/20
 */
 
import java.util.Scanner;
import java.util.ArrayList;

public class BankApp {
   
   static Scanner scan = new Scanner(System.in);
   
   static Bank bank = new Bank();
   
   static ArrayList<Deposit> depositList = new ArrayList<Deposit>();
   static ArrayList<Customer> customerList = new ArrayList<Customer>();
   
   public static void main(String[] args) {
	  System.out.println("The Local Union");
      BankApp app = new BankApp();  
      app.mainMenu();
   }
   
   public BankApp() {
      //default ctor  
   }
   
   public void mainMenu() {
	   printMenu();
	   promptChoice();
	   checkChoice();
   }
   
   public Deposit findDeposit(int ID) {
	   for (int i = 0; i < depositList.size(); i++) {
		   if (depositList.get(i).getAccountID() == ID) {
			   return depositList.get(i);
		   }
	   }
	   return null;
   }
   
   public Customer findCustomer(int ID) {
	   for (int i = 0; i < customerList.size(); i++) {
		   if (customerList.get(i).getCustomerID() == ID) {
			   return customerList.get(i);
		   }
	   }
	   return null;
   }
   
   public void printMenu() {
		System.out.println();
		System.out.println("1. Open a new account.");
		System.out.println("2. Add a second holder to an existing account.");
		System.out.println("3. Deposit/Withdraw");
		System.out.println("4. Delete a current account.");
		System.out.println("5. Print details about a account.");
		System.out.println("6. Print details about a customer.");
		System.out.println("7. Update to end month [reset withdrawals & add interest].");
		System.out.println("8. Update to next month.");
		System.out.println("9. Print details about month.");
		System.out.println("0. Exit");
		System.out.println();
	}

   public void promptChoice() {
	   System.out.println("Enter a relevant option:");
   }
   
   public void checkChoice() {
	   int choice = scan.nextInt();
	   
	   if (choice == 0) {
		   exit();
		   return;
	   }
	   else if (choice == 1) {
		   openAccount();
		   mainMenu();
	   }
	   else if (choice == 2) {
		   addHolder();
		   mainMenu();
	   }
	   else if (choice == 3) {
		   depositWithdraw();
		   mainMenu();
	   }
	   else if (choice == 4) {
		   deleteAccount();
		   mainMenu();
	   }
	   else if (choice == 5) {
		   accountDetails();
		   mainMenu();
	   }
	   else if (choice == 6) {
		   customerDetails();
		   mainMenu();
	   }
	   else if (choice == 7) {
		   endMonth();
		   mainMenu();
	   }
	   else if (choice == 8) {
		   nextMonth();
		   mainMenu();
	   }
	   else if (choice == 9) {
		   monthDetails();
		   mainMenu();
	   }
	   else {
		   promptChoice();
		   checkChoice();
	   }
	   
   }

   public void openAccount() {
	   System.out.println();
	   System.out.println("1. Deposit Account: Checking");
	   System.out.println("2. Deposit Account: Savings");
	   System.out.println("0. Return to the main menu");
	   System.out.println("Enter the type of account you wish to open:");
	   
	   int accType = scan.nextInt();
	   
	   if (accType == 0) {
		   mainMenu();
	   }
	   else if (accType == 1) {
		   Deposit newChecking = new Checking();
		   depositList.add(newChecking);
	   }
	   else if (accType == 2) {
		   Deposit newSavings = new Savings();
		   depositList.add(newSavings);
	   }
   }
   
   public void addHolder() {
	   System.out.println("Enter your account ID:");
	   
	   int ID = scan.nextInt();
	   
	   for (int i = 0; i < depositList.size(); i++) {
		   if (depositList.get(i).getAccountID() == ID) {
			   depositList.get(i).addAccountHolder();
		   }
	   }
   }
   
   public void depositWithdraw() {
	   System.out.println("Enter your account ID:");
	   
	   int ID = scan.nextInt();
	   boolean isValid = false;
	   Deposit customer = findDeposit(ID);
	   
	   for (int i = 0; i < depositList.size(); i++) {
		   if (depositList.get(i).getAccountID() == ID) {
			   isValid = true;
		   }
	   }
	   
	   if (isValid) {
		   System.out.println("1. Deposit");
		   System.out.println("2. Withdraw");
		   System.out.println("0. Return to Main Menu");
		   int answer = scan.nextInt();
		   
		   if (answer == 1) {
			   System.out.println("Enter the amount you wish to deposit:");
			   
			   int amount = scan.nextInt();
			   customer.depositMoney(amount);
		   }
		   else if (answer == 2) {
			   System.out.println("Enter the amount you wish to withdraw: ");
			   
			   int amount = scan.nextInt();
			   customer.withDrawMoney(amount);
		   }
		   else if (answer == 0){
			   System.out.println("Exiting to main menu");
			   //mainMenu();
			   //exit();
		   }
		   else{
			   System.out.println("Exiting to main menu");
			   //mainMenu();
			   //exit();
		   }
	   }
   }
   
   public void deleteAccount() {
	   System.out.println("Enter your account ID:");
	   int ID = scan.nextInt();
	   Deposit customer = findDeposit(ID);
	   customer.deleteAccount();
   }
   
   public void accountDetails() {
	   System.out.println("Enter your account ID:");
	   int ID = scan.nextInt();
	   Deposit customer = findDeposit(ID);
	   System.out.println(customer.toString());
   }
   
   public void customerDetails() {
	   System.out.println("Enter your customer ID:");
	   int ID = scan.nextInt();
	   scan.nextLine();
	   Customer customer = findCustomer(ID);
	   System.out.println(customer.toString());
   }
   
   public void endMonth() {
	   bank.isMonthEnd = true;
	   
	   for (int i = 0; i < depositList.size(); i++) {
		   depositList.get(i).addInterest();
		   depositList.get(i).resetWithdrawls();
	   }
	   System.out.println("It is now end of month!");
   }
   
   public void nextMonth() {
	   bank.nextMonth();
   }
   
   public void monthDetails() {
	   System.out.println("Current Month: " + bank.month);
	   System.out.println("Month End Flag: " + bank.isMonthEnd);
   }
   
   public void exit() {
	   System.out.println("Thanks for using the bank application");
   }
}
