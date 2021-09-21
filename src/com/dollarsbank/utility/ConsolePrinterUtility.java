package com.dollarsbank.utility;

public class ConsolePrinterUtility {

    // Default colors for the different types of messages
    public static final String MSG_HEADER = ColorsUtility.ANSI_BLUE.value;
    public static final String MSG_ERROR = ColorsUtility.ANSI_RED.value;
    public static final String MSG_CHOICE = ColorsUtility.ANSI_GREEN.value;
    public static final String USER_INPUT = ColorsUtility.ANSI_CYAN.value;
    public static final String RESET_TEXT = ColorsUtility.ANSI_RESET.value;
    
    // Welcome message seen when a user is not logged in
    public static final void defaultWelcomMsg() {
        printBoxedMsg("DOLLARSBANK Welcomes You!");
    }

    // Welcome message when a user is logged in
    public static final void customerWelcomeMsg() {
        printBoxedMsg("WELCOME Customer!!!");
    }

    // Instructions when created a new account
    public static final void newAcctMsg() {
        printBoxedMsg("Enter Details for New Account");
    }

    // Login message
    public static final void loginCredentialsMsg() {
        printBoxedMsg("Enter Login Details");
    }

    // 5 Recent Transactions header
    public static final void recentTransactionsMsg() {
        printBoxedMsg("5 Recent Transactions");
    }

    // Menu for users who hasn't logged in yet
    public static void defaultMenuOptions() {
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }

    // Menu once user has logged in
    public static void loggedInMenuOptions() {
        System.out.println("1. Deposit Amount");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Funds Transfer");
        System.out.println("4. View 5 Recent Transactions");
        System.out.println("5. Display Customer Information");
        System.out.println("6. Sign Out");
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
