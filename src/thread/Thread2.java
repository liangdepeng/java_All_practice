package thread;

/**
 * 创建线程的第一种方式：继承Thread类
 *
 * 创建线程的第二种方式：实现Runnable接口
 * 1、定义类实现Runnable接口
 * 2、覆盖接口中的run方法，将线程的任务代码封装到run方法中
 * 3、通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递
 *
 *  为什么？ 因为线程的任务都是封装在Runnable接口子类对象的run方法中，所以要在线程对象创建时必须要明确运行的任务
 *
 *  实现Runnable接口的好处
 *  1、将线程的任务从线程的子类中分离出来，进行了单独的封装
 *  2、按照面向对象的思想降任务封装成对象
 *  3、避免了java单继承的局限性
 *
 */
public class Thread2 {
    public static void main(String[] args) {
        Demoa demoa = new Demoa();
        Thread t1 = new Thread(demoa);
        t1.start();
    }
}

class Demoa implements Runnable{

    @Override
    public void run() {
        show();
    }

    private void show() {
        for (int i = 0;i<20;i++){
            System.out.println(i + "..."+Thread.currentThread().getName());
        }
    }
}