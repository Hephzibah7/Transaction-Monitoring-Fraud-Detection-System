package com.bank.fraud.service;

import com.bank.fraud.exception.InsufficientBalanceException;
import com.bank.fraud.exception.InvalidTransactionException;
import com.bank.fraud.model.*;

import java.util.*;

public class TransactionService {

    private Map<String, Account> accounts = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transaction> flaggedTransactions = new ArrayList<>();

    // Create account
    public void createAccount(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    // Deposit money
    public void deposit(String accountId, double amount)
            throws InvalidTransactionException {

        if (amount <= 0) {
            throw new InvalidTransactionException("Deposit amount must be positive");
        }

        Account account = accounts.get(accountId);
        account.credit(amount);

        Transaction tx = new Transaction(
                UUID.randomUUID().toString(),
                null,
                accountId,
                amount,
                TransactionType.DEPOSIT
        );

        transactions.add(tx);
        fraudCheck(tx);
    }

    // Withdraw money
    public void withdraw(String accountId, double amount)
            throws InsufficientBalanceException, InvalidTransactionException {

        if (amount <= 0) {
            throw new InvalidTransactionException("Withdrawal amount must be positive");
        }

        Account account = accounts.get(accountId);

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        account.debit(amount);

        Transaction tx = new Transaction(
                UUID.randomUUID().toString(),
                accountId,
                null,
                amount,
                TransactionType.WITHDRAWAL
        );

        transactions.add(tx);
        fraudCheck(tx);
    }

    // Simple fraud detection rule
    private void fraudCheck(Transaction tx) {
        if (tx.getAmount() > 100_000) {
            flaggedTransactions.add(tx);
        }
    }

    // Report
    public void printReport() {
        System.out.println("Total Transactions: " + transactions.size());
        System.out.println("Flagged Transactions: " + flaggedTransactions.size());
    }
}
