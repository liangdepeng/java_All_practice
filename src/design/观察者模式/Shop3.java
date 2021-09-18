package design.观察者模式;


import ldp.utils.SystemOutputUtils;

public class Shop3 implements Observer {

    public Shop3() {
    }

    @Override
    public void update(int newData) {
        SystemOutputUtils.println("Shop333 更新数据" + newData);
    }
}
