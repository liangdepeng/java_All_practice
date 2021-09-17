package ldp.letcode;


import ldp.utils.SystemOutputUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadTest {
    public static void main(String[] args) {
       // new Foo();
        try {
            new MultiThread(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Foo {

        private final AtomicInteger atomicInteger = new AtomicInteger(0);

        public Foo() {

            try {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SystemOutputUtils.println("线程111启动,延时5秒启动任务");
                            Thread.sleep(5000);
                            first(new Runnable() {
                                @Override
                                public void run() {
                                    SystemOutputUtils.println("A");
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SystemOutputUtils.println("线程222启动,延时3秒启动任务");
                            Thread.sleep(3000);
                            second(new Runnable() {
                                @Override
                                public void run() {
                                    SystemOutputUtils.println("B");
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SystemOutputUtils.println("线程333启动,立即启动任务");
                            third(new Runnable() {
                                @Override
                                public void run() {
                                    SystemOutputUtils.println("C");
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            atomicInteger.getAndIncrement();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (true) {
                if (atomicInteger.get() == 1)
                    break;
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            atomicInteger.getAndIncrement();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (true) {
                if (atomicInteger.get() == 2)
                    break;
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }


        public void newThread(Callback callback) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    callback.callback();
                }
            }).start();
        }

        public interface Callback {

            void callback();
        }
    }

    static class MultiThread {

        private static int num = 1;

        private static ReentrantLock lock = new ReentrantLock();
        private static final Condition conditionA = lock.newCondition();
        private static final Condition conditionB = lock.newCondition();
        private static final Condition conditionC = lock.newCondition();

        private static CountDownLatch countDownLatch = new CountDownLatch(10);

        public MultiThread(int count) throws InterruptedException {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < count; i++) {
                            lock.lock();
                            if (num != 1) {
                                conditionA.await();
                            }
                            SystemOutputUtils.print(Thread.currentThread().getName());
                            num = 2;
                            conditionB.signal();
                            lock.unlock();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }, "A").start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < count; i++) {
                            lock.lock();
                            if (num != 2) {
                                conditionB.await();
                            }
                            SystemOutputUtils.print(Thread.currentThread().getName());
                            num = 3;
                            conditionC.signal();
                            lock.unlock();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "B").start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < count; i++) {
                            lock.lock();
                            if (num != 3) {
                                conditionC.await();
                            }
                            SystemOutputUtils.println(Thread.currentThread().getName()+" - "+i);
                            num = 1;
                            conditionA.signal();
                            countDownLatch.countDown();
                            lock.unlock();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "C").start();

            countDownLatch.await();

            SystemOutputUtils.println("完毕");

        }
    }
}