package base.io;

import java.io.FileWriter;
import java.io.IOException;

public class IOexception {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("c:\\demo.txt");
            fw.write("12345" + System.getProperty("line.separator") + "456789");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
