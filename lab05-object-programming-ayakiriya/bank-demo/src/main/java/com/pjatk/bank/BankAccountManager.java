package com.pjatk.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class BankAccountManager {
    HashMap<String,BankAccount> accounts = new HashMap<>();
    HashMap<BankOperationType, ArrayList<BankAccountOperation>> operations = new HashMap<>();

    public void addAccount(BankAccount account){
        accounts.put(account.accountNumber, account);
    }

    public void registerOperation(BankAccountOperation operation){
        if(!(operations.containsKey(operation.getType()))){
            operations.put(operation.getType(), new ArrayList<>());
        }
        operations.get(operation.getType()).add(operation);
    }

    public void performDeposits(){
        ArrayList<BankAccountOperation> ops = operations.get(BankOperationType.DEPOSIT);

        for (BankAccountOperation op :
                ops) {
            op.getSourceBankAccount().addMoney(op.getMoney());
        }
    }

    public void performWithdrawals(){
        ArrayList<BankAccountOperation> ops = operations.get(BankOperationType.WITHDRAWAL);

        for (BankAccountOperation op :
                ops) {
            if(op.getSourceBankAccount().currentMoney >= op.getMoney()) {
                op.getSourceBankAccount().subtractMoney(op.getMoney());
            }
        }
    }

    public void performTransfers(){
        ArrayList<BankAccountOperation> ops = operations.get(BankOperationType.TRANSFER);

        for (BankAccountOperation op :
                ops) {
            if(op.date.compareTo(LocalDateTime.now()) <= 0 && op.getSourceBankAccount().currentMoney >= op.getMoney()){
                op.getSourceBankAccount().subtractMoney(op.getMoney());
                op.getTargetBankAccount().addMoney(op.getMoney());
            }
        }
    }
}
