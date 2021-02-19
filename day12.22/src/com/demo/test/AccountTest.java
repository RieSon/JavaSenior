package com.demo.test;

/**
 * 银行有一个账户，有两个储户分别向账户里存3000元，每次存1000，存三次，每次存完打印账户
 * 分析：
 * 1，是否是多线程问题？  有，两个储户
 * 2，是否有共享数据？   有，同一个账户
 * 3，是否有线程安全问题？ 有，两个线程同时操作一个共享数据
 * 4，如何解决线程安全问题？ 同步的三种方式
 * @author rieson
 * @create 2020-12-23-9:56
 */

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    //存钱
    public synchronized void deposit(double amt){
//        synchronized (this) {
            if (amt > 0) {
                balance += amt;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"存钱成功。余额为：" + balance);
            }
//        }
    }
}
class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {

            for (int i = 0; i < 3; i++) {
                acct.deposit(1000);
            }

    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);
        customer1.start();
        customer2.start();
        customer1.setName("储户一：");
        customer2.setName("储户二：");
    }
}
