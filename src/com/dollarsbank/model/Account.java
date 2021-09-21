package com.dollarsbank.model;

import java.time.LocalDateTime;

public class Account {
    
    static int accountCnt = 0;

    private int accountId;
    private double balance;
    private LocalDateTime openDate;

    public Account() {
        this.accountId = ++accountCnt;
        this.balance = 0;
        this.openDate = LocalDateTime.now();
    }

    public Account(double balance) {
        this.accountId = ++accountCnt;
        this.balance = balance;
        this.openDate = LocalDateTime.now();
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
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

    @Override
    public String toString() {
        return "{" +
            " accountId='" + getAccountId() + "'" +
            ", balance='" + getBalance() + "'" +
            ", openDate='" + getOpenDate() + "'" +
            "}";
    }

}
