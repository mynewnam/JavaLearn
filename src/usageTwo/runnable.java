package usageTwo;

/**
 * @author: liunairui
 * @create: 2022/9/5 10:45
 */

class MThread implements Runnable {
    Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

public class runnable {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.start();

        Thread t2 = new Thread(mThread);
        t2.start();


















    }
}
