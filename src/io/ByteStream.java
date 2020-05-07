package io;

import java.io.FileInputStream;

public class ByteStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("c:\\demo.txt");

            byte[] buf = new byte[1024];
            int len;

            while ((len = fis.read(buf))!=-1)
                System.out.println(new String(buf,0,len));
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
