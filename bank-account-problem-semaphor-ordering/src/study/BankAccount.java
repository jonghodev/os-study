package study;

import java.util.concurrent.Semaphore;

public class BankAccount {
    int balance;
    Semaphore dSem;
    Semaphore wSem;

    public BankAccount() {
        dSem = new Semaphore(0);
        wSem = new Semaphore(0);
    }

    void deposit(int amount) {
        int temp = balance + amount;
        System.out.print("+");
        balance = temp;
        wSem.release();
        try {
            dSem.acquire();
        } catch (InterruptedException e) {}
    }
    void withdraw(int amount) {
        try {
            wSem.acquire();
        } catch (InterruptedException e) {}
        int temp = balance - amount;
        System.out.print("-");
        balance = temp;
        dSem.release();
    }
    int getBalance() {
        System.out.println(balance);
        return balance;
    }
}
