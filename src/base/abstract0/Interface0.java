package base.abstract0;
/**
 * abstract class AbsDemo {
 * abstract void show1();
 * abstract void show2();
 * }
 * <p>
 * 当一个抽象类中的方法都是抽象的时候，这时可以将该抽象类用
 * 另一种形式定义和表示，就是接口  interface
 */


/**
 * // 定义接口使用的关键字不是class,是interface
 * <p>
 * 对于接口当中常见的成员，而且这些成员都有固定的修饰符。
 * 1.全局变量：public static final
 * <p>
 * 2.抽象方法：public abstract
 * <p>
 * 由此得出结论，接口中的成员都是公共的权限
 */
public class Interface0 {
    public static void main(String[] args) {
        zilei zi = new zilei();
        System.out.println(zi.num);
        System.out.println(zilei.num);
        System.out.println(interface00.num);

        WWW www = new WWW();
        www.show1();
        www.show3();
        www.funtion();
    }
}

interface interface00 {
    public static final int num = 4;

    public abstract void show1();

    public abstract void show2();
}
//

/**
 * 接口不可以实例化类与类中间是继承关系，类与接口直接是实现关系
 * 只能由实现了接口的子类并覆盖了接口中所有的抽象方法后，该子类才可以实例化
 * 否则，这个子类就是一个抽象类
 */

class zilei implements interface00 {

    @Override
    public void show1() {

    }

    @Override
    public void show2() {

    }
}

/**
 * 在java中不直接支持多继承，因为会出现调用的不稳定性
 * 所以java将多继承机制进行改良，在java中变成了多实现
 */

interface CCC{
    void show1();
}
interface MMM{
    void show3();
}
interface QQQ extends CCC,MMM{
    void funtion();
}
class WWW implements QQQ{

    @Override
    public void show1() {

    }

    @Override
    public void show3() {

    }

    @Override
    public void funtion() {

    }
}