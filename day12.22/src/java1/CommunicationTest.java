package java1;

/**
 * 线程通信的例子：使用两个线程打印1-100，线程一，线程二，交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行此方法，线程进入阻塞状态
 * notify():一旦执行此方法，就会唤醒wait()的线程，唤醒一个优先级高的线程
 * notifyAll():同上，唤醒所有线程
 * 说明：
 * 1，这些方法的调用必须使用在同步代码块中
 * 2，三个方法的调用者，必须是同步代码块中的同步监视器
 *
 * 面试题：sleep(),wait()方法有什么异同？
 * 相同点：一旦执行方法都会使线程进入阻塞状态
 * 不同点：1，两个方法生命的位置不同：Thread类中声明的sleep(),Object类中声明的wait()方法
 *       2，调用的不同，sleep()可以在任何场景使用，wait()只能在同步代码块中使用
 *       3，关于释放同步监视器：如果两个方法在同步代码块中，sleep()自动释放，wait()，需要调用notify()方法释放
 *
 *
 * @author rieson
 * @create 2020-12-23-10:32
 */
class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + "" + number);
                    number++;
                    try {
                        //使得调用此方法的线程进入阻塞
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }

        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);
        thread1.setName("线程一：");
        thread2.setName("线程二：");
        thread1.start();
        thread2.start();
    }
}
