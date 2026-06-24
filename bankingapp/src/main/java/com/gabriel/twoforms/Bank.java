package com.gabriel.twoforms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    static ArrayList<Account> accounts = new ArrayList<>();

    static void createAccount(int accountNumber, String owner) {

        for(Account acc:accounts) {
            if (acc.getAccountNumber() ==accountNumber) {
                System.out.println("Account already exists!");
                return;
            }
        }

        Account account=new Account(accountNumber,owner);
        accounts.add(account);
        System.out.println("Account created successfully.");

    }

    static void deposit(double amount,int accountNumber) {
        for(Account acc:accounts) {
            if (acc.getAccountNumber() != accountNumber) {
                System.out.println("Account not found!");

            }
            else {
                 acc.deposit(amount);
                 break;
            }
        }
    }
//
//    private static void withdraw() {
//        System.out.print("Enter account number: ");
//        String accNum = scanner.nextLine();
//        Account acc = accounts.get(accNum);
//
//        if (acc != null) {
//            System.out.print("Enter amount to withdraw: ");
//            double amount = scanner.nextDouble();
//            acc.withdraw(amount);
//        } else {
//            System.out.println("Account not found.");
//        }
//    }
//
//    private static void checkBalance() {
//        System.out.print("Enter account number: ");
//        String accNum = scanner.nextLine();
//        Account acc = accounts.get(accNum);
//
//        if (acc != null) {
//            System.out.println("Balance for " + acc.getOwner() + ": " + acc.getBalance());
//        } else {
//            System.out.println("Account not found.");
//        }
//    }

//    private static void showAccounts() {
//
//    }
//}
}
