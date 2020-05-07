package collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection0 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();

        ((ArrayList) collection).add("123");
        ((ArrayList) collection).add("add");
        ((ArrayList) collection).add("xyz");

/*        System.out.println(collection);

        Collection collection2 = new ArrayList();
        ((ArrayList) collection2).addAll(collection);

        System.out.println(collection2);

        ((ArrayList) collection2).remove(1);
        System.out.println(collection2);

        collection.removeAll(collection2);
        System.out.println(collection);*/
        for(int i = 0; i<collection.size();i++){
            System.out.println(((ArrayList) collection).get(i));
        }
    }
}
