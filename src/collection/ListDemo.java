package collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("adc");
        list.add("adw");
        list.add("qwe");
        list.add("ewr");

        list.add(1,"123");
        System.out.println(list);

        list.set(2,"666");

        System.out.println(list);

        Object o = list.get(1);

        System.out.println(o);

        List list1 = list.subList(2, 4);

        System.out.println(list1);

        System.out.println(list.remove(1));
        System.out.println(list);
    }
}
