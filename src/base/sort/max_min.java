package base.sort;

public class max_min {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 8, 100, 1, 20, 6, 3, 9};
        Compare compare = new Compare();
        System.out.println("数组中最大的元素 ： " + compare.max(arr));
        System.out.println("数组中最小的元素 ： " + compare.min(arr));
    }

}

class Compare{

    public int max(int []arr){
        int max = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (arr[i]>max)
                max = arr[i];
        }
        return max;
    }

    public int min(int[] arr){
        int min = arr[0];
        for (int j = 1;j<arr.length;j++){
            if (arr[j]<min){
                min = arr[j];
            }
        }
        return min;
    }
}