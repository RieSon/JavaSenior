package com.demo.java;

/**
 * 使用同步机制将单例模式中的懒汉模式改写为线程安全的
 *
 * @author rieson
 * @create 2020-12-22-21:53
 */
class Bank {

    private Bank() {

    }

    public static Bank b = null;

 //   public static synchronized Bank getB() {
            //方式一：效率稍差
    public static synchronized Bank getB() {

        //方式二较为高效
        if(b==null){
            synchronized (Bank.class){
                if (b == null) {
                    b = new Bank();
                }

            }
        }

        return b;
    }
}

public class BankTest {
    public static void main(String[] args) {
    Bank.getB();

    }
}
