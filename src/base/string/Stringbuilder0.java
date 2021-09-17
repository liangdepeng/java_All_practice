package base.string;

public class Stringbuilder0 {
    public static void main(String[] args) {
        /**
         * jdk1.5之后出现了功能和StringBuffer一样的对象，就是StringBuilder
         *
         * 不同的是：
         * StringBuffer是线程同步的，通常用于多线程
         * StringBuilder是线程不同步的，通常用于单线程，它的出现提高了效率
         *
         * jdk版本升级的好处：
         * 1.简化书写
         * 2.提高效率
         * 3.增加安全性
         */
    }

}

//class StringBuffer{
//    Object lock;
//
//    public StringBuffer append(int x){
//        synchronized (lock){
//
//        }
//    }
//
//    public synchronized StringBuffer delete(int start,int end){
//        synchronized (lock){
//
//        }
//    }
//}