package exception;
	/**
	异常：是在运行期间发生的不正常情况

	在Java中庸类的形式对不正常情况进行了描述和封装

	在描述不正常的情况的类，就称为异常类

	以前正常流程代码和问题处理代码相结合
	现在将正常流程代码和问题处理代码分离，提高阅读性

	其实异常就是Java通过面向对象的思想将问题封装成了对象

	用异常类对其进行描述
	不同的问题用不同的类进行具体的描述，比如角标越界，空指针等

	问题很多，意味着描述的类也很多
	将其共性进行向上抽取，形成了异常体系

	最终问题（不正常情况）就分成了两大类。
	Throwable: 无论是error，还是异常，问题，问题发生就应该可以抛出，让调用者知道并处理
					// 该体系的特点就在于Throwable及其所有的子类都具有可抛性
					可抛性到底指的是什么呢？怎么体现可抛性呢？
					其实是通过两个关键字来体现的
					throws throw，凡是可以被这两个关键字所操作的类和对象都具有可抛性
			|--1. 一般不处理的 Error
					特点：是由jvm抛出的严重性的问题
								这种问题发生一般不针对性的处理，直接修改程序
			|--2. 可以处理的 Exception

	该体系的特点：
			子类的后缀名都是用其父类名作为后缀，阅读性很强
	*/

class ExceptionDemo {
	public static void main(String[] args) {
		//int[] arr = new int[1024*1024*800];// java.lang.OutOfMemoryError: Java heap space
		//int[] arr = null;
		//System.out.println(arr[3]);// NullPointerException
		
		int i, j;
		i = 10;
		j = 0;
		//int value = i / j;// ArithmeticException: / by zero
		
		int[] arr = {1, 2, 3, 4};
		System.out.println(arr[4]);// ArrayIndexOutOfBoundsException
	}
}





















