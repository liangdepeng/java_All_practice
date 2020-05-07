package oo;
/**
 内部类访问特点：
 1.内部类可以直接访问外部类中的成员
 2.外部类要访问内部类，必须建立内部类成员

 一般用于类的设计。

 分析事物时，发现该事物描述中海油事物，而且这个事物还在访问被描述事物的内容
 这时就是还有的事物定义成内部类来描述
 */
public class Innerclass {
    public static void main(String[] args) {
        System.out.println(" ");

        Outer outer = new Outer();
        outer.method();

        Outer.Inner inner = new Outer().new Inner();
        inner.show();

   //     Outer.Inner inner1 = new Outer.Inner();

 //       Outer.Inner.fictionss();

    }
}

class Outer {
    private static final int num = 5;

    class Inner{
        void show(){
            System.out.println("show run " + num);
        }

        // 如果内部类中定义了静态成员，该内部类也必须是静态的
//        static void fictionss(){
//            System.out.println("function ..." + num);
//        }
    }

    // 外部类访问内部类的方式
    public void method(){
        Inner inner = new Inner();
        inner.show();
    }
}