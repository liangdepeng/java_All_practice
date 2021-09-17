package base.zzz;

import java.util.Scanner;

public class Add {

    public static void main(String args[]){

        double d=System.currentTimeMillis();

        RandomCalculate randomCalculate = new RandomCalculate();
        for(int i=0;i<100;i++){
            double s1 =System.currentTimeMillis();
            randomCalculate.getResults();
            double s2 =System.currentTimeMillis();
            System.out.print("本题用时:  ");
            randomCalculate.Time(((s2-s1)/1000));
        }

        System.out.println("一共答对" + randomCalculate.sum + "道题目");

        System.out.print("\r总耗时:  ");
        randomCalculate.Time(((System.currentTimeMillis()-d)/1000));
    }

}
class RandomCalculate{
    private Scanner x = new Scanner(System.in);

    int sum = 0;

    RandomCalculate(){}

    public void getResults(){
            double result = 0;
            double a=(int)(Math.random()*100);
            double b=(int)(Math.random()*99+1);

            int flag = (int) (Math.random()*4);
            switch (flag){
                case 0:
                    result = a+b;
                    System.out.print(a + " + " + b + "=");
                    break;
                case 1:
                    result = a-b;
                    System.out.print(a + " - " + b + "=");
                    break;
                case 2:
                    result = a*b;
                    System.out.print(a + " * " + b + "=");
                    break;
                case 3:
                    result = a/b;
                    System.out.print(a + " / " + b + "=");
                    break;
            }
            double c = x.nextDouble();

            if(c==result)
                sum++;

        }

        public void Time(double x){

        double second = x%60+(x-(Math.floor(x)));
        int minute = (int) ((x/60)%60);
        int hour = (int) (x/60/60);

        System.out.println(hour + " : " + minute + " : " + second);
        }

}