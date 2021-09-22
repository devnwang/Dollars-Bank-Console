package com.dollarsbank.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationUtility {
    
    public static int getValidatedIntInput(Scanner sc, String instr, int maxOpt) {
        boolean isValid = false;
        int opt = 0;

        // While input is not valid
        while (!isValid) {

            // Print the instructions
            System.out.println(instr);

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

}
