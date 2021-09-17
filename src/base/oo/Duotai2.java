package base.oo;

class Fu {
    int num = 3;
    void show() {
        System.out.println("fu show");
    }

    static void method() {
        System.out.println("fu static method");
    }
}

class Zi extends Fu {
    int num = 4;
    void show() {
        System.out.println("zi show");
    }

    static void method() {
        System.out.println("zi static method");
    }
}

class DuoTai2 {
    public static void main(String[] args) {
        Fu.method();
        Zi.method();
        Fu f = new Zi();
        f.method();
        f.show();
        System.out.println(f.num);

        Zi z = new Zi();
        System.out.println(z.num);
    }
}