package com.dollarsbank.utility;

public enum StringUtil {
    NAME("^[a-zA-Z]+$"),
    USERNAME("^[a-zA-Z]+[a-zA-Z0-9]+$"), 
    PASSWORD("^(?=.*[a-z])(?=.*[A-Z])(?=.*[-+_!@#$%^&*.,?])[A-Za-z\\d@$!%*?&]{8,}$"),
    CONFIRM("y(es)?\\Z|no?\\Z");

    public final String pattern;

    private StringUtil(String pattern) {
        this.pattern = pattern;
    }
}
