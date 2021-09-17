package base.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 将一些文字存储到硬盘一个文件中
 */
public class WriteDemo {
    public static void main(String[] args) {

        /**
         * 创建一个可以在文件中写入字符串数据的字符输出流对象
         *
         * 既然是往一个文件中写入文字数据，那么在创建对象时，就必须明确该文件(用于存储数据的目的地)
         *
         * 如果文件不存在，则会自动创建
         * 如果文件存在，则会被覆盖
         *
         * 如果构造函数中加入true, 可以实现对文件进行续写
         */
        try {

            /**
             * 调用Writer对象中的write(base.string)方法，写入数据
             * 其实数据写入到临时存储缓冲区中
             * System.getProperty("line.separator") 避免了硬编码的问题
             * 这样做可以在unix/linux和windows下换行效果一致
             * */

            FileWriter fw = new FileWriter("DEMO.txt", false);
            fw.write("abc_d0" + System.getProperty("line.separator") + "ge_ge");
            fw.write("xi_xi");

            // 进行刷新，将数据直接写到目的地中
            fw.flush();

            // 关闭流，关闭资源，在关闭前会调用flush刷新缓冲中的数据到目的地
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
