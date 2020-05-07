package io;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferReader0 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("c:\\demo.txt");

            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
