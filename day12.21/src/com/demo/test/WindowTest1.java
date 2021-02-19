package com.demo.test;

/**
 *例子：创建三个窗口卖票，总票数为100张，使用实现Ruunable接口的方式
 * 1，创建一个实现Runnable接口类
 * 2，实现类实现run()方法
 * 3，创建实现类对象
 * 4，将此对象作为参数传递到Thread类构造器中，创建Thread类的对象
 * 5，调用Thread类中的start()方法
 *
 * 比较创建线程的两种方法
 * 开发中优先选择Ruunable接口的方法：
 * 1，实现的方式没有类的单继承得局限性
 * 2，实现方式更适合处理多个线程有共享数据的情况
 * 联系：thread也继承了Runnable方法
 * 相同的点都是重写run()，将要执行的逻辑代码都是放在run()中
 * @author rieson
 * @create 2020-12-22-13:13
 */

class Window1 implements Runnable{

    private int stick =100;
    @Override
    public void run() {
        while (true){
            if (stick>0) {
                System.out.println(Thread.currentThread().getName() + "卖了多少票号：" + stick);
                stick--;
            }else{
                break;
            }

        }


    }
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
