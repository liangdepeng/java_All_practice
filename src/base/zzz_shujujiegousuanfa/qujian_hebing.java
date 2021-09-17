package base.zzz_shujujiegousuanfa;

import java.util.Scanner;

public class qujian_hebing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();//将用户输入的一整行字符串赋给s
        String[] c = s.split(",|\\s+");//用空格将其分割成字符串数组
        int size = c.length;
        int[] b = new int[size];
        for (int m = 0; m < b.length; m++) {
            b[m] = Integer.parseInt(c[m]);//讲字符串数组转换成int数组
        }
        int min = 0,min1,min2;
        int max = 0,max1,max2;
        int k = 0,count = 0;
        int[] res = new int[b.length];
        for (int i = 0;i<b.length;i=i+2){
            min1 = b[i];
            max1 = b[i+1];

            if (i==b.length-2){
                if (min1>max||max1<min){
                    res[k] = b[i];
                    res[k+1] = b[i+1];
                    break;
                }else {
                    count+=2;
                }
            }else if (min1>=min&&max1<=max){
                count+=2;
                continue;
            } else {
                for (int j = i+2;j<b.length;j=j+2){
                    min2 = b[j];
                    max2 = b[j+1];
                    if (min2>max1){
                        min = min1;
                        max = max1;
                    }else if (max2>=max1){
                        max = max2;
                        min = Math.min(min1,min2);
                    }else if (min2<=min1&&max2>min1){
                        max = Math.max(max1,max2);
                        min = min2;
                    }
                    min1 = min;
                    max1 = max;
                }
                res[k] = min;
                res[k+1] = max;
                k=k+2;
            }
        }
        for (int i = 0;i<b.length-count-1;i++){
            System.out.print(res[i]);
            if (i%2==0){
                System.out.print(",");
            }else {
                System.out.print(" ");
            }
        }
     System.out.println(res[b.length-count-1]);

     //   System.out.println(Arrays.toString(res));
    }

}


