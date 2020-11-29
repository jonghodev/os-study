package study;

import java.util.concurrent.Semaphore;

public class BankAccount {
    int balance;
    Semaphore dSam;
    Semaphore wSam;

    public BankAccount() {
        dSam = new Semaphore(0);
        wSam = new Semaphore(0);
    }

    void deposit(int amount) {
        int temp = balance + amount;
        System.out.print("+");
        balance = temp;
        wSam.release();
        try {
            dSam.acquire();
        } catch (InterruptedException e) {}
    }
    void withdraw(int amount) {
        try {
            wSam.acquire();
        } catch (InterruptedException e) {}
        int temp = balance - amount;
        System.out.print("-");
        balance = temp;
        dSam.release();
    }
    int getBalance() {
        System.out.println(balance);
        return balance;
    }
}
