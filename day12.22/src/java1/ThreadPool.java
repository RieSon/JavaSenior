package java1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *  创建线程的第四种方式：使用线程池
 *      好处：
 *      1，提高响应速度
 *      2，降低资源消耗
 *      3，便于线程管理，
 *
 * @author rieson
 * @create 2020-12-23-12:36
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2==0){
                System.out.println(i
                );
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1,提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor)executorService;
        service.setCorePoolSize(15);
      //  System.out.println(executorService.getClass());
        //2，执行指定的线程操作，需要提供Runnable，callable接口实现类的对象
        executorService.execute(new NumberThread());//适合使用于Runnable
        //3，关闭线程池
        executorService.shutdown();
    //    executorService.submit()//适合适用于callable
    }
}
