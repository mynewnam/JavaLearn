package UsageFour;

import java.util.concurrent.*;

/**
 * @author: liunairui
 * @create: 2022/9/6 16:17
 */

class NumCount implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

        NumCount numCount = new NumCount();
        Future<Integer> submit = threadPoolExecutor.submit(numCount);

        Integer result = null;
        try {
            result = submit.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("最终结果为：" + result);

        threadPoolExecutor.shutdown();
    }
}
