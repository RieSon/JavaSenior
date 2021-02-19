package com.demo.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历一个100以内的偶数，另一个遍历一个100以内的奇数
 * @author rieson
 * @create 2020-12-22-10:33
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        Mythread1 m1 = new Mythread1();
//        Mythread2 m2 = new Mythread2();
//        m1.start();
//        m2.start();
        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i %2==0) {
                        System.out.println(Thread.currentThread().getName()+""+i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i %2!=0) {
                        System.out.println(""+i);
                    }
                }
            }
        }.start();
    }
}
class Mythread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i %2==0) {
                System.out.println(Thread.currentThread().getName()+""+i);
            }
        }
    }
}
class Mythread2 extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i %2!=0) {
                System.out.println(""+i);
            }
        }
    }
}