package base.nullname;

public class Integer1 {
    public static void main(String[] args) {
        int num = 4;
        num = num + 5;

        Integer i = 4;// new Integer(4)，自动装箱，简化书写
        i = i + 6;// i = new Integer(i.intValue() + 6); i.intValue() 自动拆箱

        show(55);

        Integer a = new Integer(128);
        Integer b = new Integer(128);

        System.out.println( a == b); // false
        System.out.println(a.equals(b)); // true

        Integer x = 129; // new Integer jdk1.5之后，自动装箱，如果装箱的是一个字节，那么该数据会被共享
        // 不会重新开辟空间

        Integer y = 129; // new Integer
        System.out.println(x == y);// false
        System.out.println(x.equals(y)); // true
    }

    private static void show(Object a) {// Object a = new Integer(55);
        System.out.println("a = " + a);
    }
}
