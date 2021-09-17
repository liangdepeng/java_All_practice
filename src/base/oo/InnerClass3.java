package base.oo;
/**
匿名内部类，就是内部类的简写格式。
	必须有前提：
		内部类必须继承或实现一个外部类或者接口
匿名内部类，其实就是一个匿名子类对象

格式：new 父类or接口(){子类内容}
*/

// 举个栗子
/**
 * 匿名内部类
 */
public class InnerClass3 {
    public static void main(String[] args) {
        new Outer003().method();
    }
}
abstract class DDD{
    abstract void show();
}

class Outer003{
    int num = 5;

//    class Inner extends DDD{
//
//        @Override
//        void show() {
//            System.out.println("..." + num);
//        }
//    }

    public void method(){
//        new Inner().show();
        new DDD(){
            @Override
            void show() {
                System.out.println(" ... " + num);
            }
        }.show();//千万注意：一般直接写完整行     new DDD(){}.show();

    }
}