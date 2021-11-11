package com.company;

import java.util.Objects;
import java.util.Scanner;

public class BankMachine {


    private int countPinCodeInput;
    static  String cur = "";
    private User currentUser;
    private Scanner sc = new Scanner(System.in);

    public BankMachine(User user) {
        this.currentUser = user;
        this.countPinCodeInput = 0;
    }

    public int checkPinCode(int pinCode) {
        int i = (currentUser.getPinCode() == pinCode) ? 0 : 1;
        countPinCodeInput += i;
        return i;
    }

    public String current() {

        while (true) {
            int x;
            System.out.println("Введите валюту 1 - USD, 2 - BYN");
            x = sc.nextInt();
            switch (x) {
                case 1:
                    cur = "USD";
                    return cur;
                case 2:
                    cur = "BYN";
                    return cur;
                default:
                    System.out.println("Неверный ввод, повторите");
                    break;
            }
        }
    }

    public boolean operation(int operationNumber) {

        boolean isWorking = true;
        switch (operationNumber) {
            case 1:
                deposit(setSum(), currentUser);
                printBalance();
                break;
            case 2:
                withdraw(setSum(), currentUser);
                printBalance();
                break;
            case 3:
                printBalance();
                break;
            default:
                isWorking = false;
                break;
        }
        return isWorking;
    }


    private int setSum() {
        int x;
        while (true) {
            System.out.println("Введите сумму");
            x = sc.nextInt();
            if (x <= 0) System.out.println("Неверная сумма, повторите ввод");
            else break;
        }
        return x;
    }

    private void deposit(int sum, User user) {
        user.setBalance(user.getBalance() + sum);
    }

    private void withdraw(int sum, User user) {
        user.setBalance(user.getBalance() - sum);
    }

    private void printBalance() {
        System.out.println("Ваш баланс: " + currentUser.getBalance() + " " + cur);
    }

    public int getCountPinCodeInput() {
        return countPinCodeInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.company.BankMachine that = (com.company.BankMachine) o;
        return countPinCodeInput == that.countPinCodeInput && Objects.equals(currentUser, that.currentUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countPinCodeInput, currentUser);
    }

    @Override
    public String toString() {
        return "BankMachine{" +
                "countPinCodeInput=" + countPinCodeInput +
                ", currentUser=" + currentUser +
                '}';
    }
}

