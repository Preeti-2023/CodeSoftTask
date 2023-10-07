package com.Task3;

import java.util.Scanner;
   
public class ATM {
	 private BankAccount account;

	    public ATM(BankAccount account) {
	        this.account = account;
	    }

	    public void displayMenu() {
	        System.out.println("ATM Menu:");
	        System.out.println("1. Check Balance");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdraw");
	        System.out.println("4. Exit");
	    }

	    public void run() {
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;

	        while (!exit) {
	            displayMenu();
	            System.out.print("Enter your choice (1/2/3/4): ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Your balance is: Rs" + account.getBalance());
	                    break;
	                case 2:
	                    System.out.print("Enter the deposit amount: Rs");
	                    double depositAmount = scanner.nextDouble();
	                    account.deposit(depositAmount);
	                    System.out.println("Deposit successful. New balance: Rs" + account.getBalance());
	                    break;
	                case 3:
	                    System.out.print("Enter the withdrawal amount: Rs");
	                    double withdrawalAmount = scanner.nextDouble();
	                    boolean success = account.withdraw(withdrawalAmount);
	                    if (success) {
	                        System.out.println("Withdrawal successful. New balance: Rs" + account.getBalance());
	                    } else {
	                        System.out.println("Withdrawal failed. Insufficient funds.");
	                    }
	                    break;
	                case 4:
	                    exit = true;
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option (1/2/3/4).");
	            }
	        }
	        scanner.close();
	    }
}

