package ldp.letcode;

import ldp.utils.SystemOutputUtils;

public class Test_Wei_Wei_Op {
    public static void main(String[] args) {
        SystemOutputUtils.println(add(1, 10000));
        SystemOutputUtils.println(add(324, 10000));
        SystemOutputUtils.println(sub(100, 23));
        SystemOutputUtils.println(sub(1000, 10000));
    }


    /**
     * 位运算 加法
     */
    public static int add(int a, int b) {
        if (b == 0)
            return a;
        return add(a ^ b, (a & b) << 1);
    }


    /**
     * 位运算 减法
     */
    public static int sub(int a, int b) {
        int b2 = add(~b, 1);
        return add(a, b2);
    }
}
