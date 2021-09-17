package base.thread;

/**
 * 静态同步使用的锁是该类所属的字节码文件对象
 *
 * 可以使用getClass方法获取，亦可以用当前类名.class  因为它是静态的
 */

class Tickets implements Runnable {
    private int num = 100;
    boolean flag = true;

    //Object obj = new Object();
    public void run() {
        System.out.println(this.getClass());

        if (flag) {
            while (true) {
                synchronized (Tickets.class) {
                    if (num > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "......" + num--);
                    }
                }
            }
        } else {
            while (true)
                this.show();
        }

    }

    public synchronized void show() {
        if (num > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "......" + num--);
        }
    }
}

class SynFunctionLockDemos {
    public static void main(String[] args) {
        Tickets t = new Tickets();


        Class c1 = t.getClass();
        Class c2 = Tickets.class;
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        Thread th1 = new Thread(t);
        Thread th2 = new Thread(t);

        th1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        th2.start();
    }
}