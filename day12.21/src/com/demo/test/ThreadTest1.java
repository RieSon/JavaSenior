package com.demo.test;

/**
 * 创建多线程的方法二：
 * 1，创建一个实现Runnable()接口的类
 * 2，实现类去实现Runnable中的抽象方法
 * 3，创建实现类的对象
 * 4，将此对象作为参数传递到Thread类的构造器中，创建Thread的对象
 * 5，通过Thread类的对象来调用start()方法
 *
 * @author rieson
 * @create 2020-12-22-12:38
 */
//1，创建一个实现Runnable()接口的类
class RunNable implements Runnable{
//    int s;
//    public RunNable(int s){
//        this.s=s;
//    }
    @Override
    public void run() {

            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        //3，创建实现类的对象
        RunNable runNable = new RunNable();
        //4，将此对象作为参数传递到Thread类的构造器中，创建Thread的对象
      new  Thread(runNable).start();
        new Thread(runNable).start();

    }

}
