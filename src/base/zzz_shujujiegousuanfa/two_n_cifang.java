package base.zzz_shujujiegousuanfa;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 2 的 n 次方 打印
 */
public class two_n_cifang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Two_n n = new Two_n(sc.nextInt());
        if (n.getresults()==BigInteger.valueOf(0)){
            System.out.println("请输入正确的数字");
        }else {
            System.out.println(n.getresults());
        }
    }
}
class Two_n{
    private int N;
    Two_n(int N){
        this.N = N;
    }
    public BigInteger getresults(){
        if (N>=512&&N<=1024) {
            BigInteger bigInteger = new BigInteger("2");
            BigInteger res = bigInteger.pow(N);
            return res;
        }else {
            return BigInteger.valueOf(0);
        }
    }
}