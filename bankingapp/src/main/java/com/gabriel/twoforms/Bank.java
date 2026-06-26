package com.gabriel.twoforms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bank {

    public static boolean createAccount(int accountNumber, String owner) {
        String query = "INSERT INTO accounts (accountNumber, owner, balance) VALUES (?, ?, 0.0)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountNumber);
            stmt.setString(2, owner);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error (Create): " + e.getMessage());
            return false;
        }
    }

    public static Account getAccount(int accountNumber) {
        String query = "SELECT * FROM accounts WHERE accountNumber = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account acc = new Account(rs.getInt("accountNumber"), rs.getString("owner"));
                acc.deposit(rs.getDouble("balance"));
                return acc;
            }
        } catch (SQLException e) {
            System.out.println("Database Error (Get): " + e.getMessage());
        }
        return null;
    }

    public static ArrayList<Account> getAllAccounts() {
        ArrayList<Account> list = new ArrayList<>();
        String query = "SELECT * FROM accounts";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Account acc = new Account(rs.getInt("accountNumber"), rs.getString("owner"));
                acc.deposit(rs.getDouble("balance"));
                list.add(acc);
            }
        } catch (SQLException e) {
            System.out.println("Database Error (GetAll): " + e.getMessage());
        }
        return list;
    }

    public static boolean modifyAccount(int accountNumber, String newOwner) {
        String query = "UPDATE accounts SET owner = ? WHERE accountNumber = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newOwner);
            stmt.setInt(2, accountNumber);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Database Error (Modify): " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteAccount(int accountNumber) {
        String query = "DELETE FROM accounts WHERE accountNumber = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountNumber);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Database Error (Delete): " + e.getMessage());
            return false;
        }
    }

    public static boolean updateBalance(int accountNumber, double newBalance) {
        String query = "UPDATE accounts SET balance = ? WHERE accountNumber = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, newBalance);
            stmt.setInt(2, accountNumber);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error (Update Balance): " + e.getMessage());
            return false;
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