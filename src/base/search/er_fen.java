package base.search;

/**
 * 给定一个有序的数组，如果往该数组插入一个元素
 * 并且保证数组仍然有序，那么这个数组的下标该如何获取
 */
public class er_fen {
    public static void main(String[] args) {
        int[] arr = {1, 23, 45, 56, 78, 91, 234, 345, 456, 567};
        int key = 80;
        int index2 = halfSearch2(arr, key);
        int index = halfSearch(arr, key);
        System.out.println(index);
        System.out.println(index2);
    }

    /**
     * 二分查找数组中存在的元素下标 不存在返回-1
     * @param arr
     * @param key
     * @return
     */
    private static int halfSearch(int[] arr, int key) {
        int max = arr.length - 1;
        int min = 0;

        while (min <= max) {

            int mid = (max + min) >>> 1;
            if (arr[mid] > key)
                max = mid - 1;
            else if (arr[mid] < key)
                min = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * @param arr 数组
     * @param key 插入值
     * @return 返回下标
     */
    private static int halfSearch2(int[] arr, int key) {
        int max = arr.length - 1;
        int min = 0;
        int mid = (max + min) / 2;

        while (arr[mid] != key) {
            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;
            mid = (max + min) / 2;
            if (max == min)
                return min + 1;
            else if (max < min) {
                return min;
            }
        }
        return mid;
    }
}
