package base.oo;

    /**
     * 对象的多态性
     * <p>
     * class 动物 {}
     * <p>
     * class 猫 extends 动物 {}
     * <p>
     * class 狗 extends 动物 {}
     * <p>
     * 猫 x = new 猫();
     * <p>
     * 动物 x = new 猫();
     * <p>
     * 猫这类事物既具备了猫的形态，又具备了动物的形态。
     * 这就是对象的多态性
     * <p>
     * 简单来说，就是一个对象对应着不同类型
     * <p>
     * 多态在代码中的体现：
     * 父类或者接口的引用指向其子类的对象
     * <p>
     * 多态的好处：
     * 提高了代码的扩展性，前期定义的代码可以使用后期的内容
     * <p>
     * 多态的弊端：
     * 前期定义的内容不能使用(调用)后期子类的特有内容
     * <p>
     * 多态的前提：
     * 1.必须有关系，继承，实现
     * 2.要有覆盖
     */
public class DuoTai {
    public static void main(String[] args) {
        System.out.println("----- 多态 -----");
        Cats cats = new Cats();
        cats.eat();
        cats.catchmouse();

        Animals animals = new Cats();
        animals.eat();
        ((Cats) animals).catchmouse();

        method(new Cats());
        method(new dogs());
    }
    public static void method(Animals a){
        a.eat();

        if (a instanceof Cats){
            Cats c = (Cats) a;
            c.catchmouse();
        }else if (a instanceof dogs){
            dogs d = (dogs) a;
            d.lookHome();
        }else {

        }
    }
}

abstract class Animals{
    abstract void eat();
}

class dogs extends Animals{

    @Override
    void eat() {
        System.out.println("---啃骨头---");
    }

    void lookHome(){
        System.out.println("---看家---");
    }
}

class Cats extends Animals{

    @Override
    void eat() {
        System.out.println("---吃鱼---");
    }

    void catchmouse(){
        System.out.println("---抓老鼠---");
    }
}

class Pigs extends Animals{

    @Override
    void eat() {
        System.out.println("---饲料---");
    }

    void sleep(){
        System.out.println("---睡觉---");
    }
}