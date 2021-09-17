package base.thread;
/**
如何创建一个线程？

创建线程方式一：继承Thread类

步骤：
1.定义一个类继承Thread类
2.覆盖Thread类中的run方法
3.直接创建Thread的子类对象创建线程
4.调用start方法开启线程并调用线程的任务run方法执行

主线程的名字就是main
*/
public class Thread1 {
    public static void main(String[] args) {
/*        Thread t1 = new Thread();
        t1.start();*/
        Demox d1 = new Demox("ldp");
        Demox d2 = new Demox("bh");
        System.out.println("当前线程 == " + Thread.currentThread().getName());
        d1.start();
        d2.start();

    }
}

/**
创建线程的目的就是为了开启一条执行路径，去运行指定的代码和其他代码实现同时运行
而运行的指定代码就是这个执行路径的任务

jvm创建的主线程的任务都定义在了主函数中

而自定义的线程它的任务都定义在了主函数中

而自定义的线程它的任务在哪儿呢？
Thread类用于描述线程，线程是需要任务的，所以Thread类也是对任务的描述
这个任务就通过Thread类中的run方法来体现，也就是说，run方法就是封装自定义线程运行任务的函数

run方法中定义的就是线程要运行的任务代码

开启线程是为了运行指定代码，所以只有继承Thread类，并重写run方法。
将运行的代码定义在run方法中即可

*/
class Demox extends Thread {
    private String name;

    Demox(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        /**
         * 开启多个线程，会有运行顺序的不确定性
         */
        for (int i = 0; i < 20; i++) {
            System.out.println(name + "..." + i + "...name..." + Thread.currentThread().getName());
        }
    }
}