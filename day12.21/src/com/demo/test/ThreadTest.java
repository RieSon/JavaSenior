package com.demo.test;

/**
 * 多线程的创建，方式一：继承于thread类
 * 1，创建继承与thread类的子类
 * 2，重写thread类的run()方法-->将此线程执行的操作生命在run()方法中
 * 3，创建thread类的子类的对象
 * 4，通过此对象调用start（）方法
 *<p>
 *例子：遍历100以内的所有的偶数
 *
 * @author rieson
 * @create 2020-12-22-9:26
 */
//1创建一个继承与Thread类的子类
class MyThread extends Thread{
    //2重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i %2==0) {
                System.out.println(Thread.currentThread().getName()+""+i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //3创建threadz子类的对象
        MyThread myThread = new MyThread();
        //4通过此对象调用start():1启动当前线程，2调用当前线程的run()
        myThread.start();
        //问题一：我们不能直接调用run()方法
        //问题二：再启动一个线程，遍历100以内的偶数，不可以让已经start（）线程再次执行，会报错
        //我们需要重新创建一个线程的对象，让他再次调用start（）
        //如下操作仍然实在main线程中执行的
        MyThread myThread1 = new MyThread();
        myThread1.start();
        for (int i = 0; i < 100; i++) {
            if (i %2==0) {
                System.out.println(i+"*");
            }
        }
    }

}


