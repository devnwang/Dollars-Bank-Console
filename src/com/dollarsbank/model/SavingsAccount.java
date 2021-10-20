package com.dollarsbank.model;

public class SavingsAccount extends Account {

    private static final long serialVersionUID = 1L;

    static int savingsAcctCnt = 0;

    private double interestRate;
    private int monthlyWithdrawals;
    private double withdrawalFee;

    public SavingsAccount() {
        super();
        this.interestRate = 0.01;
        this.monthlyWithdrawals = 5;
        this.withdrawalFee = 5;
        savingsAcctCnt++;
    }

    public SavingsAccount(double balance, double interestRate, int monthlyWithdrawals, double withdrawalFee) {
        super(balance);
        this.interestRate = interestRate;
        this.monthlyWithdrawals = monthlyWithdrawals;
        this.withdrawalFee = withdrawalFee;
        savingsAcctCnt++;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getMonthlyWithdrawals() {
        return this.monthlyWithdrawals;
    }

    public void setMonthlyWithdrawals(int monthlyWithdrawals) {
        this.monthlyWithdrawals = monthlyWithdrawals;
    }

    public double getWithdrawalFee() {
        return this.withdrawalFee;
    }

    public void setWithdrawalFee(double withdrawalFee) {
        this.withdrawalFee = withdrawalFee;
    }

    @Override
    public String toString() {
        return super.toString() +
            " interestRate='" + getInterestRate() + "'" +
            ", monthlyWithdrawals='" + getMonthlyWithdrawals() + "'" +
            ", withdrawalFee='" + getWithdrawalFee() + "'" +
            "}";
    }

}
