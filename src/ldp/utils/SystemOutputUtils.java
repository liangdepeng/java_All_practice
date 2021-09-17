package ldp.utils;

public class SystemOutputUtils {

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static void printIntArray(int[] objects) {
        for (int o : objects) {
            print(o + "  ");
        }
        println("");
    }


    public static void printLongArray(long[] objects) {
        for (long o : objects) {
            print(o + "  ");
        }
        println("");
    }


    public static void printStringArray(String[] objects) {
        for (String o : objects) {
            print(o);
        }
        println("");
    }

}
