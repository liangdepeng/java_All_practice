package abstract0;

    /**
     * 雇员示例：
     * 需求：公司中程序猿有姓名，工号，薪水，工作内容
     * 项目经理除了有姓名，功能，薪水，还有奖金，工作内容
     * 对给出的需求进行数据建模
     * <p>
     * 分析：
     * 在这个问题领域中，先找出涉及的对象
     * 通过名词提炼法
     * 程序猿：
     * 属性：姓名，工号，薪水
     * 行为：工作
     * 经理：
     * 属性：姓名，工号，薪水，奖金
     * 行为：工作
     * <p>
     * 程序猿和经理不存在直接继承关系
     * <p>
     * 但是程序猿和经理却具有共性内容
     * 可以进行抽取，因为他们都是公司的雇员
     * <p>
     * 可以将程序猿和经理进行抽取，建立体系
     */

public class Abstract1 {
    public static void main(String[] args) {
        System.out.println("");
        Programmers ldp = new Programmers("ldp", "1001", 10000);
        Managers bh = new Managers("bh", "1000", 10000, 1000);

        ldp.work();
        bh.work();
    }
}
abstract class Employees{
    private String name;
    private String id;
    private double pay;

    Employees(String name,String id,double pay){
        this.name = name;
        this.id = id;
        this.pay = pay;
    }

    public abstract void work();

}

class Programmers extends Employees{

    Programmers(String name, String id, double pay) {
        super(name, id, pay);
    }

    @Override
    public void work() {
        System.out.println("程序员 ");
    }
}

class Managers extends Employees{
    private int bonus;
    Managers(String name, String id, double pay,int bonus) {
        super(name, id, pay);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理");
    }
}