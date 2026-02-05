package com.bank.fraud.model;

public class Account {
     private String accountId;
    private String customerName;
    private double balance;

    public Account(String accountId, String customerName, double balance) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        balance -= amount;
    }
}
