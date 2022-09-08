package firstClass;

import org.junit.Test;

/**
 * @author: liunairui
 * @create: 2022/9/3 21:35
 */
public class TestError {
    @Test
    public void testError() {
        try {
            int[] arr = new int[3];
            System.out.println(arr[4]);
            System.out.println("Hello1");
        }catch (IndexOutOfBoundsException e){
            System.out.println("捕获异常");
            e.printStackTrace();
        }
        System.out.println("Hello2");
    }
}
