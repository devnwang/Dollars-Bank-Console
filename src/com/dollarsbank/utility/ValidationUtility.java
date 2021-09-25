package com.dollarsbank.utility;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationUtility {

    private ValidationUtility() {
        // private constructor to make class un-instantiable
    }
    
    // Returns a valid integer input from user
    public static int getValidatedIntInput(Scanner sc, String instr, int maxOpt) {
        boolean isValid = false;
        int opt = 0;

        // While input is not valid
        while (!isValid) {

            // Print the instructions
            System.out.println(instr);

            ConsolePrinterUtility.askForInput("Enter a choice (1 - " + maxOpt + "):");

            try {
                // Integer input expected
                opt = sc.nextInt();

                // Assume that the input is valid
                isValid = true;

                // Input is not within the bounds of the options
                if (opt <= 0 || opt > maxOpt) {
                    isValid = false;
                    
                    // Out of Bounds error message
                    ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, 
                        "ERR: Input Out of Bounds. Your input needs to be between 1 and " + maxOpt + ".\n");
                }

            // Input was not an integer
            } catch (InputMismatchException e) {
                ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Input must be a numerical value.\n");
            } finally {
                // Make sure to consume the EOL characters
                sc.nextLine();
            }
        }

        // Return the valid selection
        return opt;
    }

    public static String getValidatedStrInput(Scanner sc, String instr, StringUtil type) {
        String input = "";
        boolean isValid = false;
        Pattern pattern = Pattern.compile(type.pattern);

        // Keep asking user for input until a valid input is made
        while (!isValid) {

            // Ask user for input
            ConsolePrinterUtility.askForInput(instr);
            
            // Attempt to retrieve the correct input
            try {
                input = sc.next(pattern);
                isValid = true;
            
            // Proper input not made
            } catch (InputMismatchException e) {
                // Print error message based on type of input
                switch(type) {
                    case NAME:
                        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Invalid entry. Name must not contain spaces or numerical values.");
                        break;
                    case USERNAME:
                        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Username must start with an alphabetical value.");
                        break;
                    case PASSWORD:
                        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Password must be at least 8 characters long with at least one of each type: uppercase, lowercase, special.");
                        break;
                    case EMAIL:
                        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Invalid email. Please try again.");
                        break;
                    case NUMBER:
                        ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Phone number must be entered as 10 digits.");
                        break;
                    default:
                        break;
                }

                // Declare input as invalid
                isValid = false;
            }
        }
        
        // Return the validated input
        return input;

    }

    // Confirms whether user will go through with action
    public static boolean getConfirmation(Scanner sc, String msg) {
        boolean confirm = false;
        boolean validInput = false;
        String input;

        // Pattern to look for: yes, y, no, n (case insensitive)
        Pattern pattern = Pattern.compile(StringUtil.CONFIRM.pattern, Pattern.CASE_INSENSITIVE);
        
        // While the current input is invalid
        while (!validInput) {
            System.out.println(ConsolePrinterUtility.MSG_VALIDATION + msg + " (y/n)" + ConsolePrinterUtility.USER_INPUT);

            // Attempt to receive input
            try {
                
                // Check for a specific pattern as input
                input = sc.next(pattern);

                // Assume input is true
                validInput = true;

                // If user inputs "y" or "yes" (case-insensitive)
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                    confirm = true;

                // User inputted "n" or "no"
                } else {
                    confirm = false;
                }

            // Input did not match the possible inputs (case-insensitive: y, yes, n, no)
            } catch (NoSuchElementException e) {
                validInput = false;
                ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Invalid input. Try again.");
            } finally {
                // Consume EOL
                sc.nextLine();
            }
            
        }

        // Returns valid confirmation
        return confirm;
    }

}
