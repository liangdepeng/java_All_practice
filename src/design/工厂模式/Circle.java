package design.工厂模式;


import ldp.utils.SystemOutputUtils;

public class Circle implements Shape{

    public Circle() {
    }

    @Override
    public void draw() {
        SystemOutputUtils.println("Circle draw");
    }
}
