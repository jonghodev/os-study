package study;

public class BankAccount {
    int balance;

    synchronized void deposit(int amount) {
        int temp = balance - amount;
        System.out.print("+");
        balance = temp;
    }
    synchronized void withdraw(int amount) {
        int temp = balance + amount;
        System.out.print("-");
        balance = temp;
    }
    int getBalance() {
        System.out.println(balance);
        return balance;
    }
}
