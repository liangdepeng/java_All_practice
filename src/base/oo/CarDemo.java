package base.oo;

/**
 * 用Java语言对显示生活中的事物进行描述
 * 通过类的形式来体现
 *
 * 怎么进行描述呢？
 * 对于事物的描述通常只关注两个方面
 * 一个是属性，一个是行为
 *
 * 只要明确该事物的属性和行为并定义在类中即可
 *
 * 对象，其实就是该类事物实实在在存在的个体
 *
 * 类与对象之间的关系？
 * 类，事物的描述
 * 对象，改类事物的实例，在Java中通过new来创建
 *
 *
 *
 * 需求：
 * 描述小汽车
 *
 * 分析：
 * 1.属性：
 * 轮胎数
 * 颜色
 * 2.行为：
 * 运行
 *
 * 定义类其实就是在定义类中的成员
 * 成员：成员变量<-->属性，成员函数<-->行为
 *
 * 成员变量和局部变量的区别：
 *
 * 1.成员变量定义在类中，整个类中都可以访问
 * 局部变量定义在函数、语句、局部代码块中，只在所属的区域有效
 *
 * 2.成员变量存在于堆内存的对象中
 * 局部变量存在于栈内存的方法中
 *
 * 3.成员变量随着对象的创建而存在，随着对象的消失而消失
 * 局部变量随着所属区域的执行而存在，随着所属区域的结束而释放
 *
 * 4.成员变量都有默认初始化值
 * 局部变量没有默认初始化值
 */

class Car {
    int num;// 轮胎数
    String color;// 车身颜色

    void run() {
        System.out.println(num + "..." + color);
    }
}

class CarDemo {
    public static void main(String[] args) {
        // 在计算机中创建一个car的实例，通过new关键字
        Car c = new Car();// c就是一个类类型的引用变量，指向了该类的对象
        c.num = 4;
        c.color = "red";

        c.run();

        Car c1 = new Car();
        //c1 = null;
        show(c1);

        // 1.当对象方法仅进行一次调用时，就可以简化成匿名对象
        new Car().run();// 匿名对象

        // 注意匿名对象只能调用一次，再次new出来的匿名对象，不是同一个
        new Car().num = 5;
        new Car().color = "green";
        new Car().run();

        // 2.匿名对象可以作为实际参数进行传递
        show(new Car());// c = new Car();
    }

    // 汽车改装厂
    public static void show(Car c) {
        c.num = 3;
        c.color = "black";
        System.out.println(c.num + "..." + c.color);
    }
}
















