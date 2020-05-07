package abstract0;
/**
笔记本电脑使用：
为了扩展笔记本的功能，日后要使用什么设备现在是不知道的

可以定义一个规则，只要日后出现的设备都符合这个规则就可以了
这种规则在Java当中就是接口
*/

interface USB {// 暴露的规则
	public void open();
	public void close();
}



class BookPC {
	public static void main(String[] args) {
		useUSB(new UPan());
		useUSB(new UsbMouse());
	}
	
	// 使用规则
	public static void useUSB(USB u) {// 接口类型的引用，用于接收(指向)接口的子类对象。
		if (u != null) {
			u.open();
			u.close();
		}
	}
}

// 一年之后，我们发现要使用这个UPan
// 这些设备和电脑的耦合性降低了

class UPan implements USB {
	public void open() {
		System.out.println("upan open");
	}
	public void close() {
		System.out.println("upan close");
	}
}

class UsbMouse implements USB {
	public void open() {
		System.out.println("UsbMouse open");
	}
	public void close() {
		System.out.println("UsbMouse close");
	}
}
























