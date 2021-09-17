package base.thread;

public class ThreadSingle {
    public static void main(String[] args) {

    }
}

/**
 * 饿汉式 单例
 */
class Singleton0{
    private static Singleton0 singleton0 = new Singleton0();
    private Singleton0(){}

    public static Singleton0 getInstance(){
        return singleton0;
    }
}

/**
 * 懒汉式 单例
 *
 * 加入同步是为了解决多线程安全问题
 * 加入双重判断是为了解决效率问题
 */
class Singleton1{
    private static Singleton1 singleton1 = null;
    private Singleton1(){}
    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            synchronized (Singleton1.class) {
                if (singleton1 == null)
                    singleton1 = new Singleton1();
            }
        }
        return singleton1;
    }
}