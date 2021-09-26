package com.dollarsbank.utility;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class DataGeneratorStubUtil {

    private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("E, dd MMM YYYY HH:mm:ss z");

    // Generate the transaction stub
    public static final String transactionStub(String action, double amount, Account account) {

        // Transaction
        String transaction = String.format("%s of $%.2f in [%s].%n", action, amount, account.getAccountId());

        // Account balance after transaction
        transaction += String.format("Balance - $%.2f as of %s", account.getBalance(), TIMESTAMP.format(ZonedDateTime.now()));

        return transaction;
    }

    // Save/store the user's transaction
    public static final void postTransaction(Customer customer, String transaction) {
        // Get user's current transactions
        ArrayBlockingQueue<String> transactions = customer.getTransactions();

        // Attempt to add latest transaction to queue
        try {
            transactions.add(transaction);
        
        // If queue is full
        } catch (IllegalStateException e) {
            // Remove the oldest transaction
            transactions.remove();

            // Add again
            transactions.add(transaction);
        }

        // Update the customer's transactions
        customer.setTransactions(transactions);
    }
    
}