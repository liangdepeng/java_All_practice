package zbly;

import ldp.utils.SystemOutputUtils;

import java.util.HashMap;

public class DguiHelper {

    public static void main(String[] args) {

        SystemOutputUtils.println("遍历  " + sum1(10));
        SystemOutputUtils.println("递归 " + sumDiGui(10));// 很大的问题 冗余计算 n大一点就不行了
        SystemOutputUtils.println("递归升级版 " + sumDiGuiLevelUp(10));
    }

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,F(1)= 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    // 0,1,1,2,3,5,8
    public static int sum1(int n) {
        if (n <= 1)
            return n;

        int fn_2 = 0;
        int fn_1 = 1;
        int fn = 0;

        for (int i = 2; i <= n; i++) {
            fn = (fn_1 + fn_2) % 1000000007;
            fn_2 = fn_1;
            fn_1 = fn;
        }

        return fn;
    }
    public static int sumDiGui(int n) {
        if (n <= 1)
            return n;
        return (sumDiGui(n - 1) + sumDiGui(n - 2)) % 1000000007;
    }

    /**
     * 递归升级版 利用hashmap存储计算结果 避免重复计算
     */
    private static final HashMap<Integer, Integer> resMap = new HashMap<>();

    public static int sumDiGuiLevelUp(int n) {

        if (resMap.containsKey(n))
            return resMap.get(n);

        int res = 0;
        if (n <= 1) {
            res = n;
            resMap.put(n, res);
            return res;
        }
        res = (sumDiGuiLevelUp(n - 1) + sumDiGuiLevelUp(n - 2)) % 1000000007;
        resMap.put(n, res);

        return res;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     * <p>
     * 输入：n = 0
     * 输出：1
     */
    // 1,1,2,3,5,8,13,21
    private HashMap<Integer, Integer> numsMap = new HashMap<>();

    public int numWays(int n) {

        if (numsMap.containsKey(n))
            return numsMap.get(n);

        if (n <= 1) {
            numsMap.put(n, 1);
            return 1;
        }

        int res = (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        numsMap.put(n, res);

        return res;
    }

    public int numWays2(int n) {
        if (n <= 1)
            return 1;

        int fn_2 = 1, fn_1 = 1, fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = (fn_2 + fn_1)%1000000007;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}
