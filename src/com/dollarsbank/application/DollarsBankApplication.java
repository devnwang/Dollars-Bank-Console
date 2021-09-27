package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.ValidationUtility;

public class DollarsBankApplication {
    
    public static void main(String[] args) throws Exception {
        boolean done = false;
        DollarsBankController controller = new DollarsBankController();
        boolean isLoggedIn;
        Scanner sc = new Scanner(System.in);
        String instr;
        int sel;

        while (!done) {
            
            isLoggedIn = controller.getCurrUser() != null;

            // If user logged in, get customer menu, else get guest menu
            instr = isLoggedIn ? ConsolePrinterUtility.getCustomerMenu() : ConsolePrinterUtility.getGuestMenu();

            // Get a validated input from user
            sel = ValidationUtility.getValidatedIntInput(sc, instr, controller.getNumMenuOptions());

            // Customer is signed in
            if (isLoggedIn) {
                // Customer Logic
                switch (sel) {
                    // Deposit an amount into an account
                    case 1:
                        controller.makeDeposit(sc);
                        break;

                    // Withdraw available funds from an account
                    case 2:
                        controller.makeWithdrawal(sc);
                        break;

                    // Transfer funds to another account
                    case 3:
                        controller.transferFunds(sc);
                        break;

                    // Display the last 5 transactions
                    case 4:
                        controller.printRecentTransactions();
                        break;

                    // Display current user's information
                    case 5:
                        controller.printCustomerInformation();
                        break;

                    // Sign customer out of the system
                    case 6:
                        controller.signCustomerOut(sc);
                        break;

                    default:
                        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: No such option exists.");
                        break;
                }

            // Guest user
            } else {

                // Guest Logic
                switch (sel) {
                    // Create a New Account
                    case 1:
                        controller.createNewCustomer(sc);
                        break;
                    
                    // Sign into an account
                    case 2:
                        controller.signCustomerIn(sc);
                        break;

                    // Exit the program
                    case 3:
                        done = controller.exitProgram(sc);
                        break;

                    default:
                        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: No such option exists.");
                        break;
                }
            }

        }

        // Close the scanner
        sc.close();

    }

}
