package ldp.reflection;


import ldp.utils.SystemOutputUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Fanshe {

    public static void main(String[] args) {

        // 获取class对象
         getClassObjectTest();

        // 获取类构造方法并创建对象
      //   getClassConstructorTest();

        // 获取成员变量并调用
         //getFieldTest();

        // 获取 类的全部方法
        // getMethodTest();

        // 反射调用 main 静态方法
         //getMainTest();

        // 反射方法的其它使用之---通过反射越过泛型检查
        // overCheck();

//        try {
//            Class<?> aClass = Class.forName(getValue("className"));
//            Method methodName = aClass.getMethod(getValue("methodName"));
//            methodName.invoke(null,(Object) new String[]{"1","2","4"});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

//    private static String getValue(String key){
//        try {
//            Properties properties = new Properties();
//            FileReader fileReader = new FileReader("../testfile.txt");
//            properties.load(fileReader);
//            fileReader.close();
//            return properties.getProperty(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

    /**
     * 反射方法的其它使用之---通过反射越过泛型检查
     * 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
     */
    private static void overCheck() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("test1");
        arrayList.add("test2");

        // arrayList.add(666);

        try {
            // 反射方法的其它使用之---通过反射越过泛型检查
            // 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
            // 获取ArrayList的Class对象，反向的调用add()方法，添加数据
            Class<? extends ArrayList> aClass = arrayList.getClass();
            Method method = aClass.getMethod("add", Object.class);
            method.invoke(arrayList, 666);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Object o : arrayList) {
            System.out.print(o + "  "); // test1  test2  666
        }
    }

    /**
     * 反射调用 main 静态方法
     */
    private static void getMainTest() {
        try {
            // 获取 class 对象
            Class<?> aClass = Class.forName("com.cool.ldp.reflection.Student");
            // 获取 main 方法
            Method mainMethod = aClass.getMethod("main", String[].class);
            // 调用 main 方法 因为 是静态方法 不需要对象调用 可为 null
            mainMethod.invoke(null, (Object) new String[]{"a", "b", "c"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取成员方法并调用：
     * <p>
     * 1.批量的：
     * public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
     * public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
     * <p>
     * 2.获取单个的：
     * public Method getMethod(String name,Class<?>... parameterTypes):
     * <p>
     * 参数：
     * name : 方法名；
     * Class ... : 形参的Class类型对象
     * public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
     * <p>
     * 调用方法：
     * Method --> public Object invoke(Object obj,Object... args):
     * 参数说明：
     * obj : 要调用方法的对象；
     * args:调用方式时所传递的实参；
     * ):
     */
    private static void getMethodTest() {
        try {
            Class<?> aClass = Class.forName("com.cool.ldp.reflection.Student");

            SystemOutputUtils.println("--------------------------------- 获取public 方法(包含父类)---------------------------------");
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                SystemOutputUtils.println(method);
            }
            SystemOutputUtils.println("--------------------------------- 获取public 方法---------------------------------\n\n");

            SystemOutputUtils.println("--------------------------------- 获取当前类所有的方法 包含私有 受保护的等等---------------------------------");
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                SystemOutputUtils.println(method);
            }
            SystemOutputUtils.println("--------------------------------- 获取所有的方法 包含私有 受保护的等等---------------------------------\n\n");


            SystemOutputUtils.println("--------------------------------- 获取指定 public 方法---------------------------------");
            Object instance = aClass.getConstructor().newInstance();
            Method testPublicMethod = aClass.getMethod("testPublic", String.class);
            SystemOutputUtils.println(testPublicMethod);
            testPublicMethod.invoke(instance, "反射公共方法");
            SystemOutputUtils.println("--------------------------------- 获取指定 public 方法---------------------------------\n\n");

            SystemOutputUtils.println("--------------------------------- 获取指定的任意方法 包含私有 受保护的等等---------------------------------");
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
            Object instance1 = declaredConstructor.newInstance("反射注入的私有构造 名字");
            SystemOutputUtils.println(((Student) instance1).getName());

            Method testPrivateMethod = aClass.getDeclaredMethod("testPrivate", String.class);
            testPrivateMethod.setAccessible(true);
            testPrivateMethod.invoke(instance1, "反射的私有方法");
            SystemOutputUtils.println("--------------------------------- 获取指定的任意方法 包含私有 受保护的等等---------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取成员变量并调用：
     * <p>
     * 1.批量的
     * Field[] getFields():获取所有的"公有字段"
     * Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     * <p>
     * 2.获取单个的：
     * public Field getField(String fieldName):获取某个"公有的"字段；
     * public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     * <p>
     * 设置字段的值：
     * Field --> public void set(Object obj,Object value):
     * <p>
     * 参数说明：
     * 1.obj:要设置的字段所在的对象；
     * 2.value:要为字段设置的值；
     **/
    private static void getFieldTest() {
        try {
            //1、获取class 对象
            Class<?> aClass = Class.forName("com.cool.ldp.reflection.Student");

            SystemOutputUtils.println("-------------------------获取所有字段（包括私有，受保护的等等全部字段）-----------------------");
            // 获取所有字段 所有变量
            Field[] fields = aClass.getDeclaredFields();
            for (Field filed : fields) {
                SystemOutputUtils.println(filed);
            }
            SystemOutputUtils.println("-------------------------获取所有字段（包括私有，受保护的等等全部字段）-----------------------\n\n");


            SystemOutputUtils.println("-------------------------获取所有public字段-----------------------");
            // 获取所有public字段
            Field[] fields2 = aClass.getFields();
            for (Field filed : fields2) {
                SystemOutputUtils.println(filed);
            }
            SystemOutputUtils.println("-------------------------获取所有获取所有public字段-----------------------\n\n");


            SystemOutputUtils.println("--------------------------------获取public 字段并调用-----------------------------------");
            // 获取指定 字段 name
            Field field = aClass.getField("name");
            SystemOutputUtils.println(field);
            // 获取对象
            Object instance = aClass.getConstructor().newInstance();
            // 注入 字段的值 这是public 注入 非public 要忽略 java 检查
            field.set(instance, "反射注入的名字");
            SystemOutputUtils.println(((Student) instance).name);
            SystemOutputUtils.println("--------------------------------获取public 字段并调用-----------------------------------\n\n");

            SystemOutputUtils.println("--------------------------------获取 非 public 字段并调用-----------------------------------");
            Object instance2 = aClass.getConstructor().newInstance();
            Field ageFiled = aClass.getDeclaredField("age");
            // 注入 字段的值 这是private  要忽略 java 检查
            ageFiled.setAccessible(true);
            ageFiled.set(instance2, 20);

            Field heightFiled = aClass.getDeclaredField("height");
            // 注入 字段的值 这是private  要忽略 java 检查
            heightFiled.setAccessible(true);
            heightFiled.set(instance2, 185);

            Student student = (Student) instance2;
            SystemOutputUtils.println(student.getAge() + "   " + student.getHeight());

            SystemOutputUtils.println("--------------------------------获取 非 public 字段并调用-----------------------------------\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取类构造方法并创建对象
     * <p>
     * 1).批量的方法：
     * public Constructor[] getConstructors()：所有"公有的"构造方法
     * public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
     * <p>
     * 2).获取单个的方法，并调用：
     * public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
     * public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
     * <p>
     * 调用构造方法：Constructor-->newInstance(Object... initargs)
     * <p>
     * 2、newInstance是 Constructor类的方法（管理构造函数的类）
     * <p>
     * api的解释为：newInstance(Object... initargs)
     * 使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
     * <p>
     * 它的返回值是T类型，所以newInstance是创建了一个构造方法的声明类的新实例对象。并为之调用
     */
    private static void getClassConstructorTest() {
        try {
            // 加载 class 对象
            Class<?> aClass = Class.forName("com.cool.ldp.reflection.Student");


            SystemOutputUtils.println("-----------------------获取所有公共构造方法------------------------\n");
            // 获取所有公共构造方法
            Constructor<?>[] constructors = aClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                SystemOutputUtils.println(constructor);
            }
            SystemOutputUtils.println("-----------------------获取所有公共构造方法------------------------\n\n");

            SystemOutputUtils.println("-----------------------获取所有构造方法------------------------\n");
            // 获取所有构造方法
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> constructor : declaredConstructors) {
                SystemOutputUtils.println(constructor);
            }
            SystemOutputUtils.println("-----------------------获取所有构造方法------------------------\n\n");

            SystemOutputUtils.println("\n");


            SystemOutputUtils.println("-----------------------获取公有、无参的构造方法------------------------\n");
            // 获取公有、无参的构造方法
            // 因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
            // 返回的是描述这个无参构造函数的类对象
            Constructor<?> constructor = aClass.getConstructor(null);
            SystemOutputUtils.println(constructor);
            // 调用构造方法
            Object instance = constructor.newInstance();
            SystemOutputUtils.println(instance);
            SystemOutputUtils.println("-----------------------获取公有、无参的构造方法------------------------\n\n");

            SystemOutputUtils.println("-----------------------获取一个私有构造方法，并调用------------------------\n");
            // 获取私有构造方法，并调用
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
            SystemOutputUtils.println(declaredConstructor);
            // 暴力访问(忽略掉访问修饰符)
            declaredConstructor.setAccessible(true);
            // 调用构造方法
            Object instance1 = declaredConstructor.newInstance("姓名：反射调用的 私有方法");
            SystemOutputUtils.println(instance1);
            SystemOutputUtils.println("-----------------------获取一个私有构造方法，并调用------------------------\n\n");


            SystemOutputUtils.println("-----------------------获取第二个私有构造方法，并调用------------------------\n");
            Constructor<?> declaredConstructor1 = aClass.getDeclaredConstructor(String.class, String.class, int.class);
            SystemOutputUtils.println(declaredConstructor1);
            // 暴力访问(忽略掉访问修饰符)
            declaredConstructor1.setAccessible(true);
            Student instance2 = ((Student) declaredConstructor1.newInstance("反射", "反射", 100));
            instance2.testPublic("反射的对象调用了 public 方法");
            SystemOutputUtils.println(declaredConstructor1);
            SystemOutputUtils.println("-----------------------获取第二个私有构造方法，并调用------------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Class对象的三种方式
     * 1 Object ——> getClass();
     * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
     * 3 通过Class类的静态方法：forName（String  className）(常用)
     * <p>
     * 注意：在运行期间，一个类，只有一个Class对象产生。
     * 三种方式常用第三种，第一种对象都有了还要反射干什么。
     * 第二种需要导入类的包，依赖太强，不导包就抛编译错误。
     * 一般都第三种，一个字符串可以传入也可写在配置文件中等多种方法。
     */
    private static void getClassObjectTest() {

        // 方式1
        Student student = new Student();
        Class<? extends Student> studentClass = student.getClass();
        SystemOutputUtils.println(studentClass.getName());

        // 方式2
        Class<Student> studentClass1 = Student.class;
        SystemOutputUtils.println(String.valueOf(studentClass1 == studentClass));

        // 方式3
        try {
            Class<?> aClass = Class.forName("com.cool.ldp.reflection.Student");
            SystemOutputUtils.println(String.valueOf(aClass == studentClass1));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
