package com.pjatk.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccountOperation extends ArrayList<BankAccountOperation> {
    BankAccount sourceBankAccount;
    BankAccount targetBankAccount;
    double money;
    BankOperationType type;
    LocalDateTime date;

    public BankAccountOperation(BankOperationType type){
        this.type = type;
    }

    public BankAccount getSourceBankAccount() {
        return sourceBankAccount;
    }

    public void setSourceBankAccount(BankAccount account){
        this.sourceBankAccount = account;
    }

    public BankAccount getTargetBankAccount(){
        return targetBankAccount;
    }

    public void setTargetBankAccount(BankAccount account){
        this.targetBankAccount = account;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double value){
        this.money = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public BankOperationType getType() {
        return type;
    }
}
