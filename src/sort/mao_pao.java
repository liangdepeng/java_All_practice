package sort;

import java.util.Arrays;

/**
 * 冒泡排序，两两比较，大的放在后边，每次大的都会放在最后，小的会慢慢冒上去
 */
public class mao_pao {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 8, 100, 1, 20, 6, 3, 9};
        mao_pao_sort(arr);
        int[] arr2 = {10, 5, 2, 8, 100, 1, 20, 6, 3, 9};
        mao_pao_sort2(arr2);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }


    /**
     * 冒泡排序
     *
     * @param arr 传入的数组
     */
    private static void mao_pao_sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 传入的数组
     */
    private static void mao_pao_sort2(int[] arr) {

        for (int i =arr.length-1; i>0; i--)
        {
            for (int j = 0; j<i; j++)
            {
                if (arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
