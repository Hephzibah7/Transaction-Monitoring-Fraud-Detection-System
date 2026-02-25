package com.bank.fraud.main;

import com.bank.fraud.exception.InsufficientBalanceException;
import com.bank.fraud.exception.InvalidTransactionException;
import com.bank.fraud.model.Account;
import com.bank.fraud.service.TransactionService;

public class MainApp {

    public static void main(String[] args) {

        TransactionService service = new TransactionService();

        service.createAccount(new Account("A101", "Rahul", 500000));
        service.createAccount(new Account("A102", "Anita", 300000));

        try {
            service.deposit("A101", 200000);
            service.withdraw("A101", 150000);
            service.transfer("A101","A102", 1000);
        } catch (InsufficientBalanceException | InvalidTransactionException e) {
            System.out.println(e.getMessage());
        }

        service.printReport();
    }
}
