package base.oo;
/**
内部类可以存放在局部位置上
内部类可以在局部位置上只能访问局部中被final修饰的局部变量。
*/
public class InnerClass2 {
    public static void main(String[] args) {
        Outer002 outer002 = new Outer002();
        Object obbj = outer002.menthod();
        System.out.println(obbj);
    }
}
class Outer002{
    int num = 5;

    Object menthod(){
        int x = 6;
        class Inner{
            public String toString(){
                return "show..." + x;
            }
        }
        Object o = new Inner();
        return o;
    }
    class TTT{}
}