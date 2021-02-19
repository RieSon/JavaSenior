package com.demo.test;

/**
 * 例子：创建3个窗口卖票，总票数为100张,使用继承Thread类的方法来实现
 * 存在线程安全问题
 * <p>
 * 使用同步代码块解决继承Thread的类来解决线程安全问题
 *
 * 关于同步方法的总结：
 * 1，同步方法仍然涉及到同步监视器，只是不需要我们显示的声明
 * 2，非静态的同步方法，同步监视器是：this
 *      静态的同步方法，同步监视器是：当前类本身
 * @author rieson
 * @create 2020-12-22-11:57
 */


class Window extends Thread {

    private static int ticket = 100;
   private static String i = "a";
    @Override
    public void run() {

       // synchronized (Window.class) {


        while (true) {
                show();
            }


  //      }

        }
    public static synchronized void show(){//同步监视器：Window.class
        if (ticket >0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+""+ticket);
            ticket--;
        }
    }

    public Window(String name) {
        setName(name);
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window("窗口一：");
        Window w2 = new Window("窗口二：");
        Window w3 = new Window("窗口三：");
        w1.start();
        w2.start();
        w3.start();
    }
}
