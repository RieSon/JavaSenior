package com.demo.test;

/**
 * 例子：创建3个窗口卖票，总票数为100张,使用继承Thread类的方法来实现
 *存在线程安全问题
 * @author rieson
 * @create 2020-12-22-11:57
 */


class Window extends Thread{

    private static int ticket = 100;
    @Override
    public void run() {
       while (true){
           if (ticket >0) {
               System.out.println(getName()+"卖票，票号为"+ticket);
               ticket--;
           }else{
               break;
           }
       }
    }
    public Window (String name){
        setName(name);
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1= new Window("窗口一：");
        Window w2= new Window("窗口二：");
        Window w3= new Window("窗口三：");
        w1.start();
        w2.start();
        w3.start();
    }
}
