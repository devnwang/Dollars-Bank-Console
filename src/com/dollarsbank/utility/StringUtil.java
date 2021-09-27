package com.dollarsbank.utility;

public enum StringUtil {
    NAME("[a-zA-Z]+"),
    USERNAME("[a-zA-Z]+[a-zA-Z0-9]+"), 
    PASSWORD("(?=.*[a-z])(?=.*[A-Z])(?=.*[-+_!@#$%^&*.,?])[A-Za-z\\d@$!%*?&]{8,}"),
    NUMBER("[0-9]{10}"),
    EMAIL("[a-zA-Z]+\\w+@[a-zA-Z]+\\.(com|net|edu|org)"),
    CONFIRM("y(es)?\\Z|no?\\Z"),
    MONETARY("\\d+(\\.\\d\\d)?"),
    ACCOUNT("U\\d{6}"),
    ANY(".*");

    public final String pattern;

    private StringUtil(String pattern) {
        this.pattern = pattern;
    }
}
