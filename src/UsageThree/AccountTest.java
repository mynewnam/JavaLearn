package UsageThree;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liunairui
 * @create: 2022/9/5 22:23
 */

class Account {
    private int balance;
    ReentrantLock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int money) {
        lock.lock();
        balance += money;
        System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为" + balance);
        lock.unlock();
    }
}

class Customer implements Runnable {
    private String name;
    private Account account;

    public Customer(String name, Account acct) {
        this.name = name;
        this.account = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);

        Customer c1 = new Customer("Amy", account);
        Customer c2 = new Customer("Tom", account);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.setName("Tom");
        t2.setName("Amy");

        t1.start();
        t2.start();
    }
}
