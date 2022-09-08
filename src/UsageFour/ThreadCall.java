package UsageFour;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: liunairui
 * @create: 2022/9/6 11:36
 */
class Sum implements Callable<Integer> {
    private Integer sum = 0;

    public Integer getSum() {
        return sum;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 100; i++) {
            sum += i;
            System.out.println(i);
        }

        return sum;
    }
}

public class ThreadCall {
    public static void main(String[] args) {
        Sum sum = new Sum();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(sum);
        new Thread(futureTask).start();

        try {
            Integer result = futureTask.get();
            System.out.println("最终结果为：" + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
