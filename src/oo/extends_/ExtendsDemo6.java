package oo.extends_;
/**
设计模式：对问题行之有效的解决方式，其实它是一种思想。

1.单例设计模式
	解决的问题：就是可以保证一个类在内存中的对象的唯一性
	
必须对于多个程序使用同一个配置信息对象时，就需要保证该对象的唯一性

如何保证对象唯一性呢？
1.不需要其他程序使用new创建该类对象
2.在该类创建一个本类实例
3.对外提供一个方法让其他程序可以获取该对象

步骤：
1.私有化该类构造函数
2.通过new在本类中创建一个本类对象
3.定义一个公有的方法，将创建的对象返回
*/

/*
class Demo {
	final static void show() {
		
	}
}

class Demo1 extends Demo {
	void show(int a) {
		System.out.println();
	}
}*/

class Test {
	private int num;
	
	private static Test t = new Test();
	private Test(){}
	public static Test getInstance() {
		return t;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
}

// 饿汉式
class Single {
	private static Single s = new Single();
	
	private Single() {}
	
	public static Single getInstance() {
		return s;
	}
}
// 懒汉式
class Single2 {
	private static Single2 s = null;
	
	private Single2() {}
	
	public static Single2 getInstance() {
		if (s == null)
			s = new Single2();
		return s;
	}
}

class ExtendsDemo6 {
	public static void main(String[] args) {
		//Demo1 d = new Demo1();
		//d.show();
		//Test t1 = Test.getInstance();
		//t1.setNum(10);
		//System.out.println(t1.getNum());
		
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		
		if (s1 == s2) {
			System.out.println("s1 == s2");
		}
		
		Single2 s3 = Single2.getInstance();
		Single2 s4 = Single2.getInstance();
		
		if (s3 == s4) {
			System.out.println("s3 == s4");
		}
	}
}

























