package com.demo.test;

/**
 * 测试Thread类中的方法：
 * 1，start（）：启动当前线程，调用当前线程的run()
 * 2，run()：通常需要重写Tread的类中的此方法，将要执行的操作定义在此方法中
 * 3，currentThread:静态方法，返回执行当前代码的线程
 * 4，getName():获取当前线程的名称
 * 5，setName():设置当前线程的名称
 * 6,yield():释放当前线程执行权
 * 7，join():线程a中调用线程b中join方法时，a线程就会进入阻塞状态，直到b线程执行完毕后再结束阻塞状态
 * 8，stop():强制结束当前线程，已过时，不建议使用
 * 9，sleep(long milltime):线程睡眠指定的毫秒数，
 * 10，idAlive():判断当前线程是否还存活
 *
 *
 *
 * 线程的优先级：
 * 1，
 *
 * 2，如何获取和设置线程的优先级
 *      getPriority():获取线程的优先级
 *      setPriority（int p）:设置线程的优先级
 *
 *
 *
 * @author rieson
 * @create 2020-12-22-10:46
 */
class MyTreadmethod extends Thread {
    @Override
    public void run() {

        for (int i = 0 ; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                   // sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority()+":" + "" + i);
            }
            if (i % 20 == 0) {
                yield();
            }
        }
    }

    public MyTreadmethod(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        MyTreadmethod myTreadmethod = new MyTreadmethod("Thread: 1");
        // myTreadmethod.setName("线程一");
        myTreadmethod.start();
        myTreadmethod.setPriority(Thread.MAX_PRIORITY);
        //主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                System.out.println(Thread.currentThread().getName() + "" + i);
            }
//            if (i ==20) {
//                try {
//                    myTreadmethod.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
