package design.观察者模式;

import com.cool.ldp.utils.SystemOutputUtils;

public class Shop2 implements Observer {

    public Shop2() {
    }

    @Override
    public void update(int newData) {
        SystemOutputUtils.println("Shop222 更新数据" + newData);
    }
}
