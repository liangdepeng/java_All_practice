package base.sort;

import java.util.Arrays;

/**
 * 选择排序，第一个和其他的元素依次比较，最小的元素放在第一个，完了比较第二个，以此类推
 */
public class xuan_ze {
    public static void main(String[] args) {

        int[] arr = {1, 4, 5, 9, 2, 6, 7, 80, 50, 30};
        xuan_ze_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr 传入数组
     */
    private static void xuan_ze_sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length ; j++)
            {
                if (arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
