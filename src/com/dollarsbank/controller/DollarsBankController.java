package com.dollarsbank.controller;

import java.util.HashMap;
import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.StringUtil;
import com.dollarsbank.utility.ValidationUtility;

public class DollarsBankController {
    
    private HashMap<String, Customer> customers = new HashMap<String, Customer>();

    // Current logged in user
    private Customer currUser;

    private int numMenuOptions;

    public DollarsBankController() {
        this.currUser = null;
        this.numMenuOptions = 3;
    }

    public DollarsBankController(Customer user) {
        this.currUser = user;
        this.numMenuOptions = 6;
    }

    public Customer getCurrUser() {
        return this.currUser;
    }

    public void setCurrUser(Customer currUser) {
        this.currUser = currUser;
    }

    public int getNumMenuOptions() {
        return this.numMenuOptions;
    }

    public void setNumMenuOptions(int numMenuOptions) {
        this.numMenuOptions = numMenuOptions;
    }

    // Create a new account
    public void createNewCustomer(Scanner sc) {
        // Variables needed to create a new account
        String fName, lName, address, email, number, username, password;
        double initialDeposit;

        // Print overall instructions
        ConsolePrinterUtility.printNewAcctHeader();
        
        // User's first name
        fName = ValidationUtility.getValidatedStrInput(sc, "Customer First Name:", StringUtil.NAME);

        // User's last name
        lName = ValidationUtility.getValidatedStrInput(sc, "Customer Last Name:", StringUtil.NAME);

        // User's address
        address = ValidationUtility.getValidatedStrInput(sc, "Customer Address:", StringUtil.ANY);

        // User's email address
        email = ValidationUtility.getValidatedStrInput(sc, "Customer Email:", StringUtil.EMAIL);
        
        // User's phone number
        number = ValidationUtility.getValidatedStrInput(sc, "Customer Contact Number (10-digits):", StringUtil.NUMBER);

        // User's username
        username = ValidationUtility.getValidatedStrInput(sc, "Username:", StringUtil.USERNAME);
        
        // User's password
        password = ValidationUtility.getValidatedStrInput(sc, "Password (Min: 8 characters; Must include: lower, upper & special):", StringUtil.PASSWORD);

        // Initial deposit amount
        initialDeposit = Double.parseDouble(ValidationUtility.getValidatedStrInput(sc, "Initial Deposity Amount:", StringUtil.MONETARY));

        // Create a new account for the customer
        Customer customer = new Customer(username, password, fName, lName, address, number, email, new Account(initialDeposit));

        // Store customer account in memory
        customers.put(customer.getUsername(), customer);

        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_SYS, "Account has been successfully created.");
    }

    // Sign the current user out
    public void signCustomerOut(Scanner sc) {
        // Confirm whether the user wishes to sign out
        boolean confirm = ValidationUtility.getConfirmation(sc, "Are you sure you want to sign out? (y/n)");

        // User confirms intent to sign out
        if (confirm) {
            setCurrUser(null);
            System.out.println(ConsolePrinterUtility.MSG_SYS + "Signing out..." + ConsolePrinterUtility.RESET_TEXT);
        }
    }

    public boolean exitProgram(Scanner sc) {
        // Confirm whether the user is done with the program
        boolean confirm = ValidationUtility.getConfirmation(sc, "Are you sure you want to quit the program? (y/n)");

        // User confirms intent to exit program
        if (confirm) {
            System.out.println(ConsolePrinterUtility.MSG_SYS + 
                "Thank you for banking with Dollars Bank.\nHave a nice day!" + 
                ConsolePrinterUtility.RESET_TEXT);
        }

        // Return choice
        return confirm;
    }


}
