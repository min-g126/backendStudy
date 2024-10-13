package com.ohgiraffers.section02.reflection;

public class Account {

    private String bankCode;
    
    private String accNo;
    
    private String accPwd;
    
    private int balance;


    public Account() {
    }

    public Account(String bankCode, String accNo, String accPwd) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }

    public Account(String bankCode, String accNo, String accPwd, int balance) {
        this(bankCode, accNo, accPwd);
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankCode='" + bankCode + '\'' +
                ", accNo='" + accNo + '\'' +
                ", accPwd='" + accPwd + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String deposit (int money) {

        String str = "";

        if (money > 0) {
            this.balance += money;
            str = money + "원이 입급되었습니다 :)";
        } else {
            str = "입금 금액을 잘못 입력하셨습니다!";
            
        }
        return str;
    }

    public String withdraw(int money) {

        String str = "";

        if (this.balance >= money) {
            this.balance -= money;
            str = money + "원이 출금되었습니다 :)";
        } else {
            str = "잔액이 부족합니다. 잔액을 확인해 주세요!";
        }

        return str;
    }
    
}
