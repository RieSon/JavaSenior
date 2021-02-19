package java1;

/**
 * @author rieson
 * @create 2020-12-23-11:12
 */
class Clerk{
    private int productCount=0;
    //生产产品
    public synchronized void protect() {

        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"开始生产第"+productCount+"产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void costomers() {

        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"产品");
            productCount--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始生产");
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.protect();
        }
    }
}
class Constomer extends Thread{
    private Clerk clerk;

    public Constomer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始消费");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.costomers();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        producer.setName("生产者：");
        producer.start();
        Constomer constomer = new Constomer(clerk);
        Constomer constomer1 = new Constomer(clerk);
        constomer.setName("消费者1：");
        constomer1.setName("消费者2：");
        constomer1.start();
        constomer.start();

    }
}
