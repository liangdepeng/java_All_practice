package base.oo;

    /**
     *  为什么内部类能直接访问外部类中的成员的？
     *  那是因为内部类持有了外部类的引用，
     *  外部类名.this
     */
    public class InnerClass1 {
        public static void main(String[] args) {
            new Outer001().methon();
        }
    }
    class Outer001{
        int num = 5;

        class Inner001{
            int num = 6;
            void show(){
                int num = 7;
                System.out.println(Outer001.this.num);
                System.out.println(this.num);
                System.out.println(num);
            }
        }
        void methon(){
            new Inner001().show();
        }
    }