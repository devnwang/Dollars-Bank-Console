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

            switch (sel) {
                case 1:
                    // Guest: Create New Account
                    // Customer: Deposit Amount
                    if (isLoggedIn) {
                        // TODO: Deposit Amount
                    } else {
                        controller.createNewCustomer(sc);
                    }
                    break;
                case 2:
                    // Guest: Login
                    // Customer: Withdraw Amount
                    break;
                case 3:
                    // Guest: Exit
                    if (controller.getCurrUser() == null) {
                        done = controller.exitProgram(sc);
                    }
                    // Customer: Funds Transfer
                    break;
                
                // Customer only options (must be signed in)
                case 4:
                case 5:
                case 6:
                    // Customer must be logged in for these choices
                    if (controller.getCurrUser() != null) {
                        switch (sel) {
                            case 4:
                                // TODO: Display the 5 Recent Transaction
                                break;
                            case 5:
                                // TODO: Display the Customer Information
                                break;
                            
                            case 6:
                                // Signs the current customer out of their account
                                controller.signCustomerOut(sc);
                                break;
                            default:
                                break;
                        }
                    
                    // On the off chance that a guest user somehow got to this point
                    } else {
                        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: No such options for guest users.");
                    }
                    break;

                default:
                    break;
            }
            
            //done = true;
        }

        // Close the scanner
        sc.close();


    }

}
