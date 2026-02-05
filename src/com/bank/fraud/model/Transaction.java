package com.bank.fraud.model;
import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private String fromAccount;
    private String toAccount;
    private double amount;
    private TransactionType type;
    private LocalDateTime timestamp;

    public Transaction(String transactionId,
                       String fromAccount,
                       String toAccount,
                       double amount,
                       TransactionType type) {
        this.transactionId = transactionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getFromAccount() {
        return fromAccount;
    }

}
