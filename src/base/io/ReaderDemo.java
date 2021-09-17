package base.io;

import java.io.FileReader;

public class ReaderDemo {
    public static void main(String[] args) {
        // 1.创建读取字符数据的流对象
        /**
         * 在创建读取流对象时，必须要明确被读取的文件，一定要确定该文件是存在的
         *
         * 用一个读取流关联一个已经存在的文件
         */
        try {
            FileReader fr = new FileReader("c:\\demo.txt");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.println((char) ch);
            }
//            int read = fr.read();
//            System.out.println((char) read);
//            read = fr.read();
//            System.out.println((char) read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
