package base.oo;

interface Inter{
    void show1();
    void show2();
}
class Outer004{
    class Inner implements Inter{
        @Override
        public void show1() {

        }
        @Override
        public void show2() {

        }
    }
    public void method(){
        Inner in = new Inner();
        in.show1();
        in.show2();

        Inter inter = new Inter() {
            @Override
            public void show1() {

            }

            @Override
            public void show2() {

            }
        };
    }
}

class InnerClass4{
    public static void main(String[] args) {
        show(new Inter() {
            @Override
            public void show1() {

            }

            @Override
            public void show2() {

            }
        });
    }
    public static void show(Inter in){
        in.show1();
        in.show2();
    }
}


