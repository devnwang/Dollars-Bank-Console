package com.dollarsbank.utility;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationUtility {
    
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
                    ConsolePrinterUtility.printErrorMessage(
                        "ERR: Input Out of Bounds. You're input needs to be between 1 and " + maxOpt + ".\n");
                }

            // Input was not an integer
            } catch (InputMismatchException e) {
                ConsolePrinterUtility.printErrorMessage("ERR: Input must be a numerical value.\n");
            } finally {
                // Make sure to consume the EOL characters
                sc.nextLine();
            }
        }

        // Return the valid selection
        return opt;
    }

    // Confirms whether user will go through with action
    public static boolean getConfirmation(Scanner sc, String msg) {
        boolean confirm = false;
        boolean validInput = false;
        String input;

        // Pattern to look for: yes, y, no, n (case insensitive)
        Pattern pattern = Pattern.compile("y(es)?\\Z|no?\\Z", Pattern.CASE_INSENSITIVE);
        
        // While the current input is invalid
        while (!validInput) {
            System.out.println(ConsolePrinterUtility.MSG_VALIDATION + msg + ConsolePrinterUtility.USER_INPUT);

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
                ConsolePrinterUtility.printErrorMessage("ERR: Invalid input. Try again.");
            } finally {
                // Consume EOL
                sc.nextLine();
            }
            
        }

        // Returns valid confirmation
        return confirm;
    }

}
