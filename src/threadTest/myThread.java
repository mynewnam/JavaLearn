package threadTest;

import java.io.File;

/**
 * @author: liunairui
 * @create: 2022/9/4 20:13
 */
public class myThread extends Thread{
    public myThread() {
        super();
    }

    public myThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("my new thread!");
        Thread.yield();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        myThread threadFirst = new myThread();
        threadFirst.setName("线程一");
        threadFirst.start();


        Thread.currentThread().setName("主线程");
        try {
            threadFirst.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("my main thread!");
        System.out.println(Thread.currentThread().getName());

        myThread threadSecond = new myThread("线程二");
        threadSecond.start();

    }
}
