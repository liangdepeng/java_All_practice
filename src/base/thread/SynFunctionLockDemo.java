package base.thread;

/**
 * 同步函数使用的是this
 * <p>
 * 同步函数和同步代码块的区别：
 * 同步函数的锁是固定的this
 * <p>
 * 同步代码块的锁是任意的对象
 * <p>
 * 建议使用同步代码块
 */

class Ticket implements Runnable {
    private int num = 100;
    boolean flag = true;

    //Object obj = new Object();
    public void run() {
        //System.out.println("this:" + this);

        if (flag) {
            while (true) {
                synchronized (this) {
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

class SynFunctionLockDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();

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