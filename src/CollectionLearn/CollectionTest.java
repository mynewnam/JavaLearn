package CollectionLearn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author: liunairui
 * @create: 2022/9/8 20:36
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();

        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        System.out.println(coll.size());

        Collection coll1 = new ArrayList();

        coll1.add("AA");
        coll1.add(145);
        coll.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        coll.clear();
        System.out.println();
    }
}
