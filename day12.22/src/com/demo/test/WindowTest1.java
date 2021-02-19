package com.demo.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 *例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 * 1，创建一个实现Runnable接口类
 * 2，实现类实现run()方法
 * 3，创建实现类对象
 * 4，将此对象作为参数传递到Thread类构造器中，创建Thread类的对象
 * 5，调用Thread类中的start()方法
 * 比较创建线程的两种方法
 * 开发中优先选择Ruunable接口的方法：
 * 1，实现的方式没有类的单继承得局限性
 * 2，实现方式更适合处理多个线程有共享数据的情况
 * 联系：thread也继承了Runnable方法
 * 相同的点都是重写run()，将要执行的逻辑代码都是放在run()中
 * -------------------------------------------------------
 * 1，问题：买票过程中出现了重票和，错票的 所谓的线程安全问题
 * 2，出现的原因，阻塞状态时，多个线程同时操作到同一个票
 * 3，如何解决：等第一个线程操作共享数据时，其他线程不能参与进来，直到此线程操作完成时，其他线程才能操作
 *             即使是阻塞状态时，也是如此
 * 4，在JAVA中，通过同步机制，来解决线程安全问题
 *     方式一：同步代码块
 *     synchronized(同步监视器){
 *         //需要被同步的代码
 *
 *     }
 *     说明:操作共享数据的代码 = 需要被同步的代码 --->不能包含多了，也不能包含少了
 *          共享数据 = 多个线程共同操作的数据
 *          同步监视器 = 锁：任何一个对象都可以充当锁
 *          要求：多个线程必须共用同一把锁
 *          说明：在继承Tread类，创建多线程的方式，我们可以考虑使用this充当同步监视器
 *
 *     方式二：同步方法
 *           给共享代码块，写在一个方法中，用synchrnoized 定义此方法。
 *     方式三：同步锁
 *      eg：1,面试题：synchronized 与同步锁的异同？
 *               同：都可以解决线程安全问题
 *              不同：synchronized 机制再执行玩同步代码后，自动释放同步监视器
 *              lock需要手动的释放调用(unlock)
 *          2,如何解决线程安全问题？有哪几种方式？
 *          答：同步代码块，同步方法，同步锁
 *5，同步的方式：解决掉了线程安全的问题----好处
 *  操作代码时，只能由一个线程操作，其他线程等待，相当于是一个单线程，效率低
 *
 *
 *
 *
 *
 *
 * @author rieson
 * @create 2020-12-22-13:13
 */

class Window1 implements Runnable{

    String z = "asd";
    private int stick =100;
    //1,实例化
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
            lock.lock();
            if (stick>0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖了多少票号：" + stick);
                stick--;
            }else{
                break;
            }
        }finally{
            lock.unlock();
        }
        }
    }
    }
    //方式一
//    @Override
//    public void run() {
//        while (true){
//            //用当前对象去充当
//            synchronized (this){
//            if (stick>0) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "卖了多少票号：" + stick);
//                stick--;
//            }else{
//                break;
//            }
//            }
//        }
//
//
//    }
//}

class Test{

}
public class WindowTest1 {

    public static void main(String[] args) {
        Window1 window1 = new Window1();

       Thread t1= new Thread(window1);
        t1.start();
        t1.setName("窗口一：");
        Thread t2= new Thread(window1);
        t2.start();
        t2.setName("窗口二：");
        Thread t3= new Thread(window1);
        t3.start();
        t3.setName("窗口三：");




    }

}
