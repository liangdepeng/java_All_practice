package ldp.letcode;

import ldp.utils.SystemOutputUtils;

public class TestArray {
    public static void main(String[] args) {

        SystemOutputUtils.printIntArray(Solution.spiralOrder(new int[][]{{1, 2}, {3, 4}}));

    }

    /**
     * 顺序打印矩阵
     */
    public static class Solution {
        public static int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[0];
            }
            int[] res = new int[matrix.length * matrix[0].length];
            int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
            int idx = 0;
            while (true) {
                for (int i = l; i <= r; i++) {
                    res[idx++] = matrix[u][i];
                }
                if (++u > d) {
                    break;
                }
                for (int i = u; i <= d; i++) {
                    res[idx++] = matrix[i][r];
                }
                if (--r < l) {
                    break;
                }
                for (int i = r; i >= l; i--) {
                    res[idx++] = matrix[d][i];
                }
                if (--d < u) {
                    break;
                }
                for (int i = d; i >= u; i--) {
                    res[idx++] = matrix[i][l];
                }
                if (++l > r) {
                    break;
                }
            }
            return res;
        }
    }
//    public static String reverseLeftWords(String s, int n) {
//
//    }

    public int lastRemaining(int n, int m) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(i);
//        }
//
//        for (int i=1;i<n;i++){
//
//            list.remove()
//
//        }

        return 0;

    }

    public int strToInt2(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if (length == 0) return 0;
        while (str.charAt(i) == ' ')
            if (++i == length) return 0;
        if (str.charAt(i) == '-') sign = -1;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for (int j = i; j < length; j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if (res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }


    public int strToInt(String str) {

        long res = 0;

        if (str == null || "".equals(str))
            return 0;

        char[] array = str.toCharArray();

        if (array.length == 0) {
            return 0;
        }

        boolean isFirst = true;
        int sign = 1;

        for (int i = 0; i < array.length; i++) {

            if (' ' == array[i])
                continue;

            if (isFirst && ('-' == array[i] || '+' == array[i] || (array[i] >= '0' && array[i] <= '9'))) {
                isFirst = false;
                if ('-' == array[i])
                    sign = -1;
            }

            if (array[i] < '0' || array[i] > '9')
                break;

            if (res > Integer.MAX_VALUE)
                break;

            res = res * 10 + (array[i] - '0');
        }

        return (int) (res * sign);


    }

//    写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
//
//
//    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//
//    当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//
//    该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//
//    注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//
//    在任何情况下，若函数不能进行有效的转换时，请返回 0。
//
//    说明：
//
//    假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
//
//
//
//    输入: "42"
//    输出: 42
//
//
//    输入: "   -42"
//    输出: -42
//    解释: 第一个非空白字符为 '-', 它是一个负号。
//                 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
//    示例 3:
//
//    输入: "4193 with words"
//    输出: 4193
//    解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
//    示例 4:
//
//    输入: "words and 987"
//    输出: 0
//    解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//    因此无法执行有效的转换。
//    示例 5:
//
//    输入: "-91283472332"
//    输出: -2147483648
//    解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
//                 因此返回 INT_MIN (−231) 。


}
