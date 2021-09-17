package base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Copyfile {
    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();

        //（code）
        // copy("c:\\在人间-王建房.flac","f:\\在人间-王建房.flac");

        copy2("c:\\西虹市首富HD国语中字.mp4", "f:\\西虹市首富HD国语中字.mp4");

        long time2 = System.currentTimeMillis();
        long interval = time2 - time1;
        System.out.println(interval);

    }

    /**
     * 更快
     *
     * @param s
     * @param s1
     */

    private static void copy2(String s, String s1) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(s));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(s1));

            int len1;
            byte[] buf = new byte[1024];
            while ((len1 = bis.read(buf)) != -1) {
                bos.write(buf, 0, len1);
            }
            bis.close();
            bos.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copy(String s, String s1) {
        try {
//            FileInputStream fis = new FileInputStream(s);
//            BufferedInputStream bis = new BufferedInputStream(fis);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(s));

//            FileOutputStream fos = new FileOutputStream(s1);
//            BufferedOutputStream bos = new BufferedOutputStream(fos);

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(s1));

            int ch;
            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }


            bis.close();
            bos.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
