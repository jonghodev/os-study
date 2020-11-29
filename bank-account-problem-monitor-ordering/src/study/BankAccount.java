package study;

public class BankAccount {
    int balance;
    // Parent 의 차례를 의미한다.
    boolean pTurn = true;

    synchronized void deposit(int amount) {
        int temp = balance - amount;
        System.out.print("+");
        balance = temp;

        pTurn = false;
        // Child 를 깨우고
        notify();
        try {
            // 자신은 블록된다.
            wait();
        } catch (InterruptedException e) {}
    }
    synchronized void withdraw(int amount) {
        // Parent 의 차례일 경우 블록한다.
        if (pTurn) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        int temp = balance + amount;
        System.out.print("-");
        balance = temp;

        pTurn = true;
        // Parent 를 깨운다
        notify();
    }
    int getBalance() {
        System.out.println(balance);
        return balance;
    }
}
