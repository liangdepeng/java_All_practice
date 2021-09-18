package design.工厂模式;


import ldp.utils.SystemOutputUtils;

public class Rect implements Shape{

    public Rect() {
    }

    @Override
    public void draw() {
        SystemOutputUtils.println("Rect draw");
    }
}
