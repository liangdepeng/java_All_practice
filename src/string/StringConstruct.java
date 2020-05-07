package string;

public class StringConstruct {
    public static void main(String[] args) {
        /**
         * 将字节数组或者字符数组转成字符串可以通过String类的构造函数完成
         */
        stringconstruct2();
    }

    /**
     * 根据选定下标构建字符串
     *
     */
    private static void stringconstruct2(){
        char[] arr = {'w','a','b','c','x'};
        String s = new String(arr,1,3);
        System.out.println("s = " + s);
    }
    private static void stringconstruct(){
        String s = new String(); //等效于 String s = ""; 并不是 String s = null;
        byte[] arr = {97,66,67,68};
        String s1 = new String(arr);
        System.out.println("s1 = " + s1); //s1 = aBCD
    }
}
