package UsageFour;

/**
 * @author: liunairui
 * @create: 2022/9/6 10:49
 */

class Clerk {
    private int productNumber = 0;

    public synchronized void produce() {
        if (productNumber < 20) {
            productNumber++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ":正在生产第" + productNumber + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consume() {
        if (productNumber > 0) {
            System.out.println(Thread.currentThread().getName() + ":正在消费第" + productNumber + "个产品");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            productNumber--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + "开始生产产品");

        while (true) {
            clerk.produce();
        }
    }
}

class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始消费产品");

        while (true) {
            clerk.consume();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Customer c1 = new Customer(clerk);
        Producer p1 = new Producer(clerk);

        Thread t1 = new Thread(c1, "消费者1");
        Thread t2 = new Thread(p1, "生产者1");

        t1.start();
        t2.start();

    }
}
