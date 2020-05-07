package design_pattems;

/**
 * 单例设计模式
 */
public class Single {
    public static void main(String[] args) {

        Singleton s1 = Singleton.getSingleton();
        s1.show();
        Singleton s2 = Singleton.getSingleton();
        s2.show();

        if (s1 == s2) {
            System.out.println("s1==s2");
        }


        Singleton3 sss1 = Singleton3.Singleton3;
        sss1.show();
        Singleton3 sss2 = Singleton3.Singleton3;
        sss2.show();

        if (sss1 == sss2) {
            System.out.println("sss1==sss2");
        }
    }
}

/**
 * 饿汉式
 */

class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }

    void show() {
        System.out.println("我是饿汉式单例模式");
    }
}


    /**
     * 懒汉式
     */

    class Singleton2 {
        private static Singleton2 singleton2 = null;

        private Singleton2() {
        }

    public static Singleton2 getSingleton2() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

/**
 * 枚举
 */

    enum Singleton3 {
        Singleton3;

        void show() {
            System.out.println("我是 枚举 单例模式");
        }
    }

/**
 * 静态内部类
 */

class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static final Singleton4 getSingleton4() {
        return SingletonHolder.INSTANCE;
    }
}

    /**
     * 静态代码块
     */

    class Singleton5 {
        static {
            Singleton5 singleton5 = new Singleton5();
        }
    }

