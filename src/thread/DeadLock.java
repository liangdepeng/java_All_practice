package thread;

/**
 * 死锁 ： 常见情景之一（同步的嵌套）
 */
public class DeadLock {
    public static void main(String[] args) {
        Dead dead = new Dead();

        Thread T1 = new Thread(dead);
        Thread T2 = new Thread(dead);
        T1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dead.flag = false;
        T2.start();
    }
}

class Dead implements Runnable{

    private int num = 100;
    Object object = new Object();
    boolean flag = true;

    @Override
    public void run() {
        if (flag){
            while (true){
                synchronized (object){
                    show();
                }
                System.out.println("in while...");
            }
        }else {
            while (true){
                this.show();
            }
        }
    }

    private synchronized void show() {
        System.out.println("in show...");
        synchronized (object){
            if (num>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " ... " + num--);
            }
        }
    }
}