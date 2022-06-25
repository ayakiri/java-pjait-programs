package com.pjatk.bank;

public class BankAccount {
    String accountNumber;
    Double currentMoney;

    public BankAccount(String accountNum){
        this.accountNumber = accountNum;
        this.currentMoney = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getCurrentMoney() {
        return currentMoney;
    }

    public void addMoney(double value){
        this.currentMoney += value;
    }

    public void subtractMoney(double value){
        this.currentMoney = this.currentMoney - value;
    }
}
