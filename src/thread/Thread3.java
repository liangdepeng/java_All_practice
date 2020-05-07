package thread;



public class Thread3 {
    public static void main(String[] args) {
        Cus cus = new Cus();
        Thread T1 = new Thread(cus);
        Thread T2 = new Thread(cus);
        T1.start();
        T2.start();
    }
}
class Bank{
    private int sum;
   // private Object object = new Object();

    /**
     * 同步函数
     * @param num
     */
    public  void add(int num) {
       // synchronized (object) {
            sum += num;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sum = " + sum);
        }
   // }
}
class Cus implements Runnable{
    private Bank bank = new Bank();
    @Override
    public void run() {
        for (int i = 0; i< 3;i++){
            bank.add(100);
        }
    }
}