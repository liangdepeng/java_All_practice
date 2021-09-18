package zbly;

import ldp.utils.SystemOutputUtils;

public class OtherHelper {
    public static void main(String[] args) {
        SystemOutputUtils.print(myPow(10, -10));
    }

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     */
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1 || x == 1) return x;

        boolean flag = n < 0;
        long b=n;

        long count=flag?(-b):b;
        double temp = x;

        for (int i = 1; i < count; i++) {
            x = x * temp;
        }

        return flag ? 1 / x : x;

    }
}
