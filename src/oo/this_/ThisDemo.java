package oo.this_;

/**
 * 当成员变量和局部变量重名，可以用关键字this来区别
 * <p>
 * this: 代表对象，代表哪个对象呢？当前对象
 * this就是所在函数所属对象的引用
 * 简单说：哪个对象调用了this所在的函数，this就代表哪个对象
 * <p>
 * this也可以用于在构造函数中调用其他构造函数
 * 注意：只能定义在构造函数的第一行。因为初始化动作要先执行
 */

class Person3 {
    private String name;
    private int age;

    Person3() {
        name = "baby";
        age = 1;
        System.out.println("Person3 run");
    }

    Person3(String name) {
        this();
        this.name = name;
    }

    Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void speak() {
        System.out.println(this.name + ":" + this.age);
    }

    /*
    判断是否是同龄人
    */
    public boolean compare(Person3 p) {
		/*if (this.age == p.age)
			return true;
		else
			return false;*/
        return this.age == p.age;
    }
}

class ThisDemo {
    public static void main(String[] args) {
        Person3 p1 = new Person3("aa", 30);
        Person3 p2 = new Person3("zz", 12);

        //System.out.println(p2.compare(p1)); // false

        Person3 p3 = new Person3("小强");
        p3.speak();
    }
}




















