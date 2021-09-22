package com.dollarsbank.utility;

public class ConsolePrinterUtility {

    // Default colors for the different types of messages
    public static final String MSG_HEADER = ColorsUtility.ANSI_BLUE.value;
    public static final String MSG_ERROR = ColorsUtility.ANSI_RED.value;
    public static final String MSG_CHOICE = ColorsUtility.ANSI_GREEN.value;
    public static final String MSG_VALIDATION = ColorsUtility.ANSI_PURPLE.value;
    public static final String MSG_SYS = ColorsUtility.ANSI_YELLOW.value;
    public static final String USER_INPUT = ColorsUtility.ANSI_CYAN.value;
    public static final String RESET_TEXT = ColorsUtility.ANSI_RESET.value;
    
    // Welcome message seen when a user is not logged in
    public static final void printGuestWelcomeMsg() {
        printBoxedMsg("DOLLARSBANK Welcomes You!");
    }

    // Welcome message when a user is logged in
    public static final void printCustomerWelcomeMsg() {
        printBoxedMsg("WELCOME Customer!!!");
    }

    // Instructions when created a new account
    public static final void printNewAcctHeader() {
        printBoxedMsg("Enter Details for New Account");
    }

    // Login message
    public static final void printLoginHeader() {
        printBoxedMsg("Enter Login Details");
    }

    // 5 Recent Transactions header
    public static final void printRecentTransHeader() {
        printBoxedMsg("5 Recent Transactions");
    }

    // Error Message
    public static final void printErrorMessage(String msg) {
        System.out.println(MSG_ERROR + msg + RESET_TEXT);
    }

    // Asking for user input
    public static final void askForInput(String msg) {
        System.out.println(MSG_CHOICE + msg + USER_INPUT);
    }

    // Menu for users who hasn't logged in yet
    public static String guestMenuOptions() {
        return
            "1. Create New Account\n" +
            "2. Login\n" +
            "3. Exit\n";
    }

    // Menu once user has logged in
    public static String customerMenuOptions() {
        return
            "1. Deposit Amount\n" +
            "2. Withdraw Amount\n" +
            "3. Funds Transfer\n" +
            "4. View 5 Recent Transactions\n" +
            "5. Display Customer Information\n" +
            "6. Sign Out\n";
    }

    // Helper function used to box a message
    private static void printBoxedMsg(String msg) {
        int msgLength = getMaxStringLen(msg);
        
        printLine(msgLength);
        System.out.printf("%s| %s |%s%n", MSG_HEADER, padString(msg, msgLength), RESET_TEXT);
        printLine(msgLength);

    }

    // Helper functions used to format the boxed message nicely

    private static void printLine(int maxWidth) {
        System.out.println(MSG_HEADER + "+" + fill('-', maxWidth + 2) + "+" + RESET_TEXT);
    }

    private static int getMaxStringLen(String string) {
        return string.length();
    }

    private static String fill(char ch, int length) {
        StringBuilder sb = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            sb.append(ch);
        }

        return sb.toString();
    }

    private static String padString(String str, int length) {
        StringBuilder sb = new StringBuilder(str);
        return sb.append(fill(' ', length - str.length())).toString();
    }

}
