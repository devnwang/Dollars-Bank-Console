package com.dollarsbank.model;

import java.util.List;

public class Customer {

    static int customerCnt = 0;
    
    private int customerId;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String address;
    private String phoneNumber;
    private String email;
    private List<Account> accounts;
    private String[] transactions;

    public Customer(String username, String password, String fName, String lName, String address, String phoneNumber, String email, List<Account> accounts, String[] transactions) {
        this.customerId = ++customerCnt;
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accounts = accounts;
        this.transactions = transactions;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFName() {
        return this.fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return this.lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String[] getTransactions() {
        return this.transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", fName='" + getFName() + "'" +
            ", lName='" + getLName() + "'" +
            ", address='" + getAddress() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", accounts='" + getAccounts() + "'" +
            ", transactions='" + getTransactions() + "'" +
            "}";
    }


}
