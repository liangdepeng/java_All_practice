package design.工厂模式;

import com.cool.ldp.utils.SystemOutputUtils;

public class Circle implements Shape{

    public Circle() {
    }

    @Override
    public void draw() {
        SystemOutputUtils.println("Circle draw");
    }
}
