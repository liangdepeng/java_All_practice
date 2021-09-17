package base.string;

public class String0 {
    public static void main(String[] args) {
        stringDemo2();
    }

    public static void stringDemo2() {
        String s = "abc";// 创建一个字符串对象在常量池中

        // 至少创建一个对象，也可能创建两个对象，一个new一个字符串对象在堆内存
        String s1 = new String("abc");

        System.out.println(s == s1);
        // 比较的是地址

        System.out.println(s.equals(s1));
        // string类中的equals复写了Object中的equals简历了string类自己的判断字符串对象是否
        // 相同的依据，其实就是比较字符串的内容

        System.out.println("s=" + s);
        System.out.println("s1=" + s1);

    }

    /**
     * 演示字符串定义的第一种方式，并明确字符串常量池的特点
     * 池中没有就建立，池中有，就直接用
     */
    private static void stringDemo() {
        String s = "abc";// 存储在字符串常量池中
        s = "nba";
        String s1 = "abc";
        System.out.println(s == s1);
        System.out.println("s=" + s);
    }
}
