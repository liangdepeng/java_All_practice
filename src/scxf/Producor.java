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
    }

}
