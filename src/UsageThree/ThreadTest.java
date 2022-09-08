package UsageThree;


/**
 * @author: liunairui
 * @create: 2022/9/5 21:27
 */

class Window implements Runnable {
    private int number = 100;
    //方法三
//    ReentrantLock lock = new ReentrantLock();
//
//    @Override
//    public void run() {
//        while (true) {
//            lock.lock();
//            if (number > 0) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                System.out.println(Thread.currentThread().getName() + ":" + number);
//                number--;
//                lock.unlock();
//            } else {
//                lock.unlock();
//                break;
//            }
//        }
//    }
    //方法一
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();
                if (number > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number--;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);

        t1.start();
        t2.start();

    }
}
