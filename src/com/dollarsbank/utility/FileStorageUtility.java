package com.dollarsbank.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class FileStorageUtility {
    
    private static final String DATAFILE = "resources/data.txt";
    
    // Export the data to a file to be saved somewhere
    public static final void exportData(Map<String, Customer> users) {
        
        // Retrieve the number of users that are being saved
        int numUsers = users.size();

        File file = new File(DATAFILE);

        // If the file does not exist
        if (!file.exists()) {

            // Try to create it
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Unable to create data file.");
            }
        }

        // Attempt to write users to the file
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
            
            // First store the number of users whose data is being stored
            writer.writeInt(numUsers);

            // Then write in user data
            for (Customer user : users.values()) {
                writer.writeObject(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
            ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Unable to save data.");
        }
    }
    
    // Import the data from a saved file
    public static final Map<String, Customer> importData() {
        Map<String, Customer> users = new HashMap<String, Customer>();
        Customer user;

        File file = new File(DATAFILE);

        // If the file contains any data
        if (file.length() > 0) {

            // Attempt to read from the file
            try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(new File(DATAFILE)))) {
                
                // Read the number of users that are stored in the file so that we know how many users to read
                int numUsers = (int) reader.readInt();

                // Read from file the number of users specified
                for (int i = 0; i < numUsers; i++) {
                    
                    // Read a user from the file
                    user = (Customer) reader.readObject();

                    // Store the user into the hashmap
                    users.put(user.getUsername(), user);

                    // Update customer and account count
                    Customer.incrCustomerCnt();
                    Account.incrAccountCnt();

                }

            } catch (IOException | ClassNotFoundException e) {
                ConsolePrinterUtility.printMessage(ConsolePrinterUtility.MSG_ERROR, "ERR: Unable to import data.");
            }
        }

        return users;
    }

}
