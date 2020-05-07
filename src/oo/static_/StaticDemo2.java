package oo.static_;


class StaticDemo2 {
	public static void main(String[] args) throws Exception {
		Thread.sleep(5000);
		Person2.method();
		
		Person2 p = new Person2("java", 20);
		p.show();
	}
}

class Person2 {
	private String name;
	private int age;
	static String country = "CN";
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void show() {
		System.out.println(Person.country + ":" + this.name + ":" + this.age);
	}
	public static void method() {
		System.out.println(Person.country);
	}
}