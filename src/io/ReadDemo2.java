package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDemo2 {
    public static void main(String[] args) {
        try {
            /**
             * 使用read(char[])读取文本文件数据
             *
             * 先创建字符数组
             */
            FileReader fr = new FileReader("c:\\demo.txt");
            char[] chars = new char[1024];
            int len;
            while ((len=fr.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
