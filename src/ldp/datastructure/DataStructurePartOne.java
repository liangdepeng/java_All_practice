package ldp.datastructure;


import ldp.utils.IWork;
import ldp.utils.SystemOutputUtils;
import ldp.utils.ThreadUtils;

import java.util.Arrays;

/**
 * 排序 相关
 * <p>
 * https://juejin.cn/post/6844903633914445837#heading-1 数据结构与算法概览
 * <p>
 * https://blog.csdn.net/weixin_41190227/article/details/86600821 数组排序
 *
 * <p>
 * 数据结构与算法 -01
 */
public class DataStructurePartOne {

    public static void main(String[] args) {

        initArray();

        // 用于排序时间测试
        int[] test = new int[100000];
        for (int i = 0; i < 100000; i++) {
            test[i] = (int) (Math.random() * 100000);
        }

        int[] test2 = Arrays.copyOf(test, 100000);
        int[] test3 = Arrays.copyOf(test, 100000);
        int[] test4 = Arrays.copyOf(test, 100000);
        int[] test5 = Arrays.copyOf(test, 100000);
        int[] test6 = Arrays.copyOf(test, 100000);
        int[] test7 = Arrays.copyOf(test, 100000);
        int[] test111 = Arrays.copyOf(test, 100000);


        // 排序结果测试

        int[] ints = {1, 6, 4, 2, 78, 96, 34, 63, 12, 45, 7, 90};
        long mills = System.currentTimeMillis();
        quickSort(ints, 0, 11);
        SystemOutputUtils.println("快速排序: " + (System.currentTimeMillis() - mills));
        SystemOutputUtils.printIntArray(ints);

        bubbleSort(new int[]{1, 6, 4, 2, 78, 96, 34, 63, 12, 45, 7, 90});
        selectSort(new int[]{1, 6, 4, 2, 78, 96, 34, 63, 12, 45, 7, 90});
        insertSort(new int[]{1, 6, 4, 2, 78, 96, 34, 63, 12, 45, 7, 90});

        SystemOutputUtils.println(" ");

        //Thrown when a stack overflow occurs because an application recurses too deeply.
        ThreadUtils.openNewWorkThread(new IWork() {
            @Override
            public void doBackgroundWork() {
                long timeMillis = System.currentTimeMillis();
                quickSort(test, 0, 99999);
                SystemOutputUtils.println("快速排序 10万随机数字 数据排序测试 时间：" + (System.currentTimeMillis() - timeMillis));

                long timeMillis2 = System.currentTimeMillis();
                quick(test4,0,99999);
                SystemOutputUtils.println("快速排序 10万随机数字 数据排序测试 时间：" + (System.currentTimeMillis() - timeMillis2));
            }
        });


        ThreadUtils.openNewWorkThread(new IWork() {
            @Override
            public void doBackgroundWork() {
                long timeMillis = System.currentTimeMillis();
                bubbleSort(test2);
                SystemOutputUtils.println("冒泡排序 10万随机数字 数据排序测试 时间：" + (System.currentTimeMillis() - timeMillis));
            }
        });

        ThreadUtils.openNewWorkThread(new IWork() {
            @Override
            public void doBackgroundWork() {
                long timeMillis = System.currentTimeMillis();
                insertSort(test3);
                SystemOutputUtils.println("插入排序 10万随机数字 数据排序测试 时间：" + (System.currentTimeMillis() - timeMillis));
            }
        });

        {
            long timeMillis = System.currentTimeMillis();
            selectSort(test111);
            SystemOutputUtils.println("选择排序 10万随机数字 数据排序测试 时间：" + (System.currentTimeMillis() - timeMillis));
        }


    }

    /**
     * 只声明了类型和长度
     * 数据类型 []  数组名称 = new 数据类型[数组长度];
     * 声明了类型，初始化赋值，大小由元素个数决定
     * 数据类型 [] 数组名称 = {数组元素1，数组元素2，......}
     * <p>
     * 大小固定，不能动态扩展(初始化给大了，浪费；给小了，不够用)，插入快，删除和查找慢
     */
    private static void initArray() {
        int[] a = new int[10];
        int[] b = new int[]{0, 1, 2, 3, 4};
        String[] c = new String[]{"hello"};

        SystemOutputUtils.printIntArray(a);
        SystemOutputUtils.printIntArray(b);
        SystemOutputUtils.printStringArray(c);

        SystemOutputUtils.println(a[3]);
        SystemOutputUtils.println(b[1]);
        SystemOutputUtils.println(c[0]);
        SystemOutputUtils.println("--------------------------");
    }

    /**
     * 冒泡排序
     * <p>
     * 冒泡排序 是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * 简言之，比较相邻的两个元素 大的放在后面 然后整个循环一次以后 最大的就在最后面了
     */
    private static void bubbleSort(int[] a) {
        long startMills = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        if (a.length < 100) {
            SystemOutputUtils.println("冒泡排序： " + (System.currentTimeMillis() - startMills));
            SystemOutputUtils.printIntArray(a);
        }

    }

    /**
     * 选择排序
     * <p>
     * 每次找一遍 找出最小的放在最前面  然后接下来从第二个开始找其他的数里面最小的 以此类推
     */
    private static void selectSort(int[] a) {
        long startMills = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            // 记录 最小的 index
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                // 如果更小的 记录 index
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            // 交换 前面的和后面的最小的数字
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }

        if (a.length < 100) {
            SystemOutputUtils.println("选择排序： " + (System.currentTimeMillis() - startMills));
            SystemOutputUtils.printIntArray(a);
        }
    }

    public static void insertSort(int[] array) {
        long mills = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        if (array.length < 100) {
            SystemOutputUtils.println("插入排序 :" + (System.currentTimeMillis() - mills));
            SystemOutputUtils.printIntArray(array);
        }
    }

    static int count = 0;

    private static void quickSort(int[] array, int left, int right) {
        long mills = System.currentTimeMillis();
        if (left < right) {
            //Swap(array[left], array[(left + right) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = left, j = right, x = array[left];
            while (i < j) {
                while (i < j && array[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    array[i++] = array[j];

                while (i < j && array[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    array[j--] = array[i];
            }
            array[i] = x;
            quickSort(array, left, i - 1); // 递归调用
            quickSort(array, i + 1, right);

            // SystemOutputUtils.println(count++);
        }
    }

    public static void quick(int[] nums, int L, int R) {

        if (L>=R){
            return;
        }

        int l = L, r = R;
        int pivot = nums[l];

        while (l < r) {

            while (l < r && nums[r] >= pivot) {
                r--;
            }

            if (l<r){
                nums[l]=nums[r];
            }

            while (l < r && nums[l] <= pivot) {
                l++;
            }

            if (l<r){
                nums[r]=nums[l];
            }

        }

        nums[l] = pivot;

        quick(nums, L, l - 1);
        quick(nums, l + 1, R);
    }

    public static void quick2(int[] nums,int l,int r){
        if (l>=r)
            return;
        int pivot = nums[l];
        int left = l,right=r;

        while (left<right){

            while (left<right&&nums[right]>=pivot){
                right--;
            }

            if (left<right){
                nums[left]=nums[right];
            }

            while (left<right&&nums[left]<=pivot){
                left++;
            }

            if (left<right){
                nums[right]=nums[left];
            }

            if (left>=right){
                nums[left]=pivot;
            }
        }

        quick2(nums,l,left-1);
        quick2(nums,left+1,r);
    }

}