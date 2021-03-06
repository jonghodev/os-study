package study;

import java.util.concurrent.Semaphore;

public class BankAccount {
    int balance;
    Semaphore sem;

    public BankAccount() {
        sem = new Semaphore(1);
    }

    void deposit(int amount) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {}

        int temp = balance + amount;
        System.out.print("+");
        balance = temp;
        sem.release();
    }
    void withdraw(int amount) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {}
        int temp = balance - amount;
        System.out.print("-");
        balance = temp;
        sem.release();
    }
    int getBalance() {
        System.out.println(balance);
        return balance;
    }
}
