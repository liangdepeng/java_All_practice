package collection;

public class ParaMeter {
    public static void main(String[] args) {
        int sum = newAdd(1,2,3,4);
        System.out.println("sum = " + sum);
    }

    /**
     * 函数的可变参数   (必须在列表的最后)
     * @param x
     * @param arr
     * @return
     */
    private static int newAdd(int x,int... arr) { //int[] arr;
        int sum = 0;
        for (int i = 0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum + x;
    }
}
