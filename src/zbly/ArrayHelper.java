package zbly;

import ldp.utils.SystemOutputUtils;

import java.util.HashSet;

public class ArrayHelper {
    public static void main(String[] args) {
        SystemOutputUtils.printIntArray(exchange(new int[]{1, 3, 5}));
    }

    /**
     * 找出数组中任意一个重复的数字。
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums == null)
            return 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.add(nums[i]))
                return nums[i];
        }
        return 0;
    }

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 现有矩阵 matrix 如下：
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target=5，返回true。
     * 给定target=20，返回false。
     */
    int[][] matrix = new int[][]{
            {1, 2, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}};

    // 顺序遍历 大了就换行
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target)
                    break;
            }
        }
        return false;
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：[2,2,2,0,1]
     * 输出：0
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];

    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */

    public String replaceSpace(String s) {
        if (s == null)
            return "";

        char[] array = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] == ' ' ? "%20" : array[i]);
        }
        return builder.toString();
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。：
     * 输入：nums =[1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     * 快排思想
     *
     * 前后交换
     *
     */
    public static int[] exchange(int[] nums) {
        if (nums == null)
            return new int[]{};
        if (nums.length == 1) {
            return nums;
        }

        int l = 0, r = nums.length - 1, temp;

        while (l < r) {

            while (l < r && (nums[l] & 1) == 1) {
                l++;
            }

            while (l < r && (nums[r] & 1) == 0) {
                r--;
            }

            if (l < r) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        return nums;
    }
}
