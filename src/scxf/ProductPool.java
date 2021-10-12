package scxf;

import java.util.LinkedList;

public class ProductPool {
    // 仓库最大容量
    private final int MAX_SIZE = 10;
    // 仓库存储
    private final LinkedList<Object> list = new LinkedList<>();

    public ProductPool() {
    }

    public void produce() {
        synchronized (list) {
            while (list.size() >= MAX_SIZE) {
                System.out.println("仓库已满。。。");
                try {
                    list.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("生产者 " + Thread.currentThread().getName() + " 生产了一个产品 ，共有产品 " + list.size());

            list.notifyAll();
        }
    }

    public void consume() {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("已消费完。。。");
                try {
                    list.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("消费者 " + Thread.currentThread().getName() + " 消费了一个产品 ，共有产品 " + list.size());
            list.notifyAll();
        }
    }

    public static class Productor implements Runnable {
        ProductPool productPool;

        public Productor(ProductPool productPool) {
            this.productPool = productPool;
        }


        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    productPool.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Customer implements Runnable {
        ProductPool productPool;

        public Customer(ProductPool productPool) {
            this.productPool = productPool;
        }

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1500);
                    productPool.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * ........
 * 消费者 Thread-5 消费了一个产品 ，共有产品 7
 * 消费者 Thread-3 消费了一个产品 ，共有产品 6
 * 生产者 Thread-2 生产了一个产品 ，共有产品 7
 * 生产者 Thread-1 生产了一个产品 ，共有产品 8
 * 生产者 Thread-0 生产了一个产品 ，共有产品 9
 * 生产者 Thread-1 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 仓库已满。。。
 * 消费者 Thread-4 消费了一个产品 ，共有产品 9
 * 生产者 Thread-2 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 消费者 Thread-5 消费了一个产品 ，共有产品 9
 * 消费者 Thread-3 消费了一个产品 ，共有产品 8
 * 生产者 Thread-0 生产了一个产品 ，共有产品 9
 * 生产者 Thread-1 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 仓库已满。。。
 * 消费者 Thread-5 消费了一个产品 ，共有产品 9
 * 生产者 Thread-0 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 消费者 Thread-4 消费了一个产品 ，共有产品 9
 * 消费者 Thread-3 消费了一个产品 ，共有产品 8
 * 生产者 Thread-2 生产了一个产品 ，共有产品 9
 * 生产者 Thread-1 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 仓库已满。。。
 * 仓库已满。。。
 * 消费者 Thread-3 消费了一个产品 ，共有产品 9
 * 生产者 Thread-1 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 仓库已满。。。
 * 消费者 Thread-4 消费了一个产品 ，共有产品 9
 * 消费者 Thread-5 消费了一个产品 ，共有产品 8
 * 生产者 Thread-2 生产了一个产品 ，共有产品 9
 * 生产者 Thread-0 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 仓库已满。。。
 * 仓库已满。。。
 * 消费者 Thread-3 消费了一个产品 ，共有产品 9
 * 生产者 Thread-0 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 仓库已满。。。
 * 消费者 Thread-4 消费了一个产品 ，共有产品 9
 * 消费者 Thread-5 消费了一个产品 ，共有产品 8
 * 生产者 Thread-1 生产了一个产品 ，共有产品 9
 * 生产者 Thread-2 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 仓库已满。。。
 * 仓库已满。。。
 * 消费者 Thread-3 消费了一个产品 ，共有产品 9
 * 生产者 Thread-2 生产了一个产品 ，共有产品 10
 * 仓库已满。。。
 * 仓库已满。。。
 * 消费者 Thread-4 消费了一个产品 ，共有产品 9
 * 消费者 Thread-5 消费了一个产品 ，共有产品 8
 *
 */
