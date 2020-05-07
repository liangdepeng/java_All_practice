package string;

public class StringObject {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = s1.intern();//intern是返回字符串常量池的引用
        String s3 = "abc";
        System.out.println("s2 = " + s2);
        System.out.println(s2 == s3);
        // 注意new String和 = ""的区别，以及intern是返回字符串常量池的引用
    }
}
