package study;

public class Parent extends Thread {
    BankAccount b;
    Parent(BankAccount b) {
        this.b = b;
    }
    public void run() {
        for (int i=0; i<100000; i++)
            b.deposit(1000);
    }
}
