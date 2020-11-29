package study;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount b = new
                BankAccount();
        Parent p = new Parent(b);
        Child c = new Child(b);
        c.start();
        p.start();
        p.join();
        c.join();
        System.out.println( "\nbalance = " + b.getBalance());
    }
}
