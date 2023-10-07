package com.Task3;

public class Main {

    public static void main(String[] args) {
	double initialBalance = 1000.0; // Initial balance in the bank account
    BankAccount userAccount = new BankAccount(initialBalance);
    ATM atm = new ATM(userAccount);

    System.out.println("Welcome to the ATM!");
    atm.run();

}
    }
