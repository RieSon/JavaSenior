package java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口，-----jdk5.0接口
 * 1,创建一个实现Callable的实现类
 * 2，实现call方法，将此线程需要执行的操作声明在call()中
 * 3，创建实现类的的对象
 * 4，将此对象作为传递的参数放到TutureTask构造器中，创建TutureTask的对象
 * 5，将TutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，调用start()
 *
 * 如何理解Callable接口比实现runnable接口创建多线程的方式强大？
 * 1，call()可以有返回值，可以抛出异常，获取异常信息
 * 2，Callable支持泛型
 * * @author rieson
 * @create 2020-12-23-11:52
 */
class A implements Callable{


    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum +=i;
            }
        }
        return sum;
    }
}
public class CallbleTest  {
    public static void main(String[] args) {
        A a = new A();
        FutureTask futureTask = new FutureTask(a);
        new Thread(futureTask).start();
        try {
            //get()返回值即为FutureTask构造器Callable实现重写的call()方法的返回值
            Object o = futureTask.get();
            System.out.println(o );

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
