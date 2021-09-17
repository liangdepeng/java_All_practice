package base.oo.extends_;

/**
 * 当子父类中出现成员函数一模一样的情况，会运行子类的函数
 * 这种现象，称之为覆盖操作，这是函数在子父类中的特性.
 * 函数两个特性：
 * 1.重载，同一个类中，overload
 * 2.覆盖，子类中。覆盖也称为重写，覆写，override
 * <p>
 * 覆盖注意事项：
 * 1.子类方法覆盖父类方法时，子类权限必须要大于等于父类的权限。
 * 2.静态只能覆盖静态，或被静态覆盖。
 */

class Object {
    String name;
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    Object(String name) {
        this.name = name;
    }
}

/**
 * 人类
 */
class Personx extends Object {
    int age;
    int height;
    String birthday;
    String country;

    Personx(String name) {
        super(name);
    }
}

/**
 * 英雄类
 */
class Hero extends Personx {
    String history; // 个人历史
    int skill;// 技能
    int atk; // 攻击力
    int defense;// 抗性 防御力

    Hero(String name) {
        super(name);
    }

    void hit(Hero h) {
    } // 打击对面英雄的方法，子类才知道如何打击
}

/**
 * 坦克类
 */
class Tank extends Hero {
    Tank(String name) {
        super(name);
    }

    void hit(Hero h) {
        System.out.println("用肉体去打击敌人" + h.getName());
    }
}

class ExtendsDemo3 {
    public static void main(String[] args) {
        Tank jiutong = new Tank("酒桶");
        jiutong.hit(new Hero("盖伦"));
    }
}














