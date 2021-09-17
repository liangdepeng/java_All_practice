package ldp.reflection;


import ldp.utils.SystemOutputUtils;

public class Student {

    public String name;
    public String id;
    private int age;
    private int height;
    private int weight;

    public static void main(String[] args) {
        System.out.println("Student main() 被调用了");
    }

    public Student() {
        SystemOutputUtils.println("private Student()");
    }

    private Student(String name) {
        this.name = name;
        SystemOutputUtils.println("public Student(String name):  " + name);
    }

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        SystemOutputUtils.println("public Student(String name, String id):  " + name + "  " + id);
    }

    protected Student(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        SystemOutputUtils.println("protected Student(String name, String id, int age):   " + name + "  " + id + "  " + age);
    }

    private void testPrivate(String str) {
        System.out.println("我是私有方法  testPrivate  " + str);
    }

    protected void testProtect(String str){
        System.out.println("我是受保护的方法  testProtect  " + str);
    }

    public void testPublic(String str) {
        System.out.println("我是公有方法  testPublic  " + str);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
