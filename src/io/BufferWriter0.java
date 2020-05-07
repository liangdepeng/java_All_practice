package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriter0 {
    public static void main(String[] args) {
        try {
            /**
             *   // 为了提高写入的效率，使用字符流的缓冲区
             *   // 创建了一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联
             */
            FileWriter fw = new FileWriter("c:\\txt.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("hello , java");
            bw.newLine();
            bw.write("hello");
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
