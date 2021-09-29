package com.dollarsbank.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Account implements Serializable {
    
    static int accountCnt = 0;

    private String accountId;
    private double balance;
    private LocalDateTime openDate;

    public Account() {
        this.accountId = String.format("U%06d", ++accountCnt);
        this.balance = 0;
        this.openDate = LocalDateTime.now();
    }

    public Account(double balance) {
        this.accountId = String.format("U%06d", ++accountCnt);
        this.balance = balance;
        this.openDate = LocalDateTime.now();
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getOpenDate() {
        return this.openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    // Used by FileStorageUtility to properly update the account count that doesn't get incremented by object deserialization
    public static void incrAccountCnt() {
        accountCnt++;
    }

    @Override
    public String toString() {
        return "{" +
            " accountId='" + getAccountId() + "'" +
            ", balance='" + getBalance() + "'" +
            ", openDate='" + getOpenDate() + "'" +
            "}";
    }

}
