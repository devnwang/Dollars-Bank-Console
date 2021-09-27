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
        transaction += balanceStatement(account);

        return transaction;
    }

    // Transaction stub for user making the transfer
    public static final String transferToStub(double amount, Account from, Customer to) {
        String transaction = String.format("Transfer of $%.2f from [%s] to %s [%s].%n", amount, from.getAccountId(), to.getFullName(), to.getAccount().getAccountId());
        
        transaction += balanceStatement(from);

        return transaction;
    }

    // Transaction stub for the user receiving the transfer
    public static final String transferFromStub(double amount, Customer from, Account to) {
        String transaction = String.format("Transfer of $%.2f from %s [%s] to [%s].%n", amount, from.getFullName(), from.getAccount().getAccountId(), to.getAccountId());
        
        transaction += balanceStatement(to);

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

    private static final String balanceStatement(Account acct) {
        return String.format("Balance - $%.2f as of %s", acct.getBalance(), TIMESTAMP.format(ZonedDateTime.now()));
    }
    
}