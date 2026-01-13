package main;

import java.util.Scanner;

/* Class to represent the user's bank account */
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

/* Class to represent the ATM machine */
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful!");
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("✅ Deposit successful!");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + account.getBalance());
    }

    public void start() {
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        } while (choice != 4);
    }
}

/* Main class */
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
