package CollectionLearn;

import org.junit.Test;

import java.util.*;

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

//        System.out.println(coll.size());

        Collection coll1 = new ArrayList();

        coll1.add("AA");
        coll1.add(145);
        coll.addAll(coll1);

        Iterator iterator = coll.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Object obj: coll) {
            System.out.println(obj);
        }
    }

}
