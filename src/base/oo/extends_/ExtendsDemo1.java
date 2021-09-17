package base.oo.extends_;

/**
 * 继承的好处：
 *  1、提高了代码的复用性
 *  2、让类与类之间产生了关系，给第三个特征多态提供了前提
 *
 *  java中不支持多继承，只能单继承
 *
 *  单继承：一个子类只能有一个直接父类
 *
 *  多继承：一个子类可以有多个直接父类（java不允许），因为多个父类中有相同成员，会产生调用不确定性
 *         在java中是通过“多实现”的方式来体现的
 *
 *  java支持多层继承
 */
public class ExtendsDemo1 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "ldp";
        s.age = 20;
        s.study();

        Teacher teacher = new Teacher();
        teacher.name = "bh";
        teacher.age = 18;
        teacher.teach();
    }
}
class People{
    String name;
    int age;
}
class Student extends People{
    void study(){
        System.out.println(name + " " + age);
    }
}
class Teacher extends People{
    void teach(){
        System.out.println(name + " " + age + "  教书育人");
    }
}