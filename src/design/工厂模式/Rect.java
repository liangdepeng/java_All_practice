package design.工厂模式;

import com.cool.ldp.utils.SystemOutputUtils;

public class Rect implements Shape{

    public Rect() {
    }

    @Override
    public void draw() {
        SystemOutputUtils.println("Rect draw");
    }
}
