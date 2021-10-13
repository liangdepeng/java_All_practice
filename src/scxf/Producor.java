package scxf;

/**
 * 生产者消费者模型
 */
public class Producor {

    public static void main(String[] args) {
        ProductPool productPool = new ProductPool();

        Thread pr_1 = new Thread(new ProductPool.Productor(productPool));
        Thread pr_2 = new Thread(new ProductPool.Productor(productPool));
        Thread pr_3 = new Thread(new ProductPool.Productor(productPool));

        Thread cs_1 = new Thread(new ProductPool.Customer(productPool));
        Thread cs_2 = new Thread(new ProductPool.Customer(productPool));
        Thread cs_3 = new Thread(new ProductPool.Customer(productPool));

        pr_1.start();
        pr_2.start();
        pr_3.start();

        cs_1.start();
        cs_2.start();
        cs_3.start();


//        try {
//
//            FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    Thread.sleep(5000);
//                    return "futureTask";
//                }
//            });
//
//            Thread thread = new Thread(futureTask);
//            thread.start();
//
//            // futureTask.get() 得不到结果会阻塞当前线程
//            SystemOutputUtils.println(futureTask.get());
//
//            SystemOutputUtils.println(1);
//            SystemOutputUtils.println(1);
//            SystemOutputUtils.println(1);
//            SystemOutputUtils.println(1);
//            SystemOutputUtils.println(1);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
