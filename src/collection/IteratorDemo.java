package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 迭代器
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();

        ((ArrayList) c1).add("123");
        ((ArrayList) c1).add("adc");
        ((ArrayList) c1).add("465");
        ((ArrayList) c1).add("dfe");

        System.out.println(c1);

        Iterator iterator = c1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for (Iterator it = c1.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
