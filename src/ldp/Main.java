package ldp;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        // System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        // System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        //   System.out.println(maxScore()); 数据结构与算法

         strTest();
       // change("11111111111", new char[]{'1', '1', '1', '1'});
    }

    public static int maxScore(int[] cardPoints, int k) {

        int length = cardPoints.length;
        int unless = length - k;
        int sum = 0;
        int allSum = 0;

        for (int cardPoint : cardPoints) {
            allSum = allSum + cardPoint;
        }

        if (length == k) {
            return allSum;
        }

        for (int i = 0; i < unless; i++) {
            sum = sum + cardPoints[i];
        }

        int moveMinSum = sum;

        for (int i = unless; i < length; i++) {
            sum = sum + cardPoints[i] - cardPoints[i - unless];
            moveMinSum = Math.min(moveMinSum, sum);
        }


        return allSum - moveMinSum;
    }

//    public int subarraysWithKDistinct(int[] A, int K) {
//        if (A.length == K) {
//            return K;
//        }
//
//        if ()
//    }

    public static void strTest() {
        String s1 = new String("123456");
        println(s1);
        s1 = "qwert";
        println(s1);
        println(" ");

        String s2 = new String("2222222");
        char[] chars = new char[]{'2', '2', '2', '2'};
        change(s2, chars);
        println(s2);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + "  ");
        }
    }

    public static void change(String str, char[] chars) {
        chars[0] = 'a';

        str = "123123123123";
        chars = new char[]{'1', '2', '5'};

//        println(str);
//        println(chars);
    }

    public static void println(Object content) {
        System.out.println(content);
    }
}
