package design.单例模式;


import ldp.utils.SystemOutputUtils;

public class UtilsManager {


    private UtilsManager() {

    }

    // 饿汉式 线程安全
    private static final UtilsManager utilsManager = new UtilsManager();
    public static UtilsManager getInstance() {
        return utilsManager;
    }

    // 懒加载 线程不安全
    private static UtilsManager utilsManager2;
    public static UtilsManager getInstance2() {
        if (utilsManager2 == null)
            utilsManager2 = new UtilsManager();
        return utilsManager2;
    }

    // 懒加载 线程安全
    private static UtilsManager utilsManager3;
    public static synchronized UtilsManager getInstance3() {
        if (utilsManager3 == null)
            utilsManager3 = new UtilsManager();
        return utilsManager3;
    }

    // 双检锁/双重校验锁（DCL) 线程安全
    private volatile static UtilsManager utilsManager4;
    public static UtilsManager getInstance4() {
        if (utilsManager4 == null) {
            synchronized (UtilsManager.class) {
                if (utilsManager4 == null) {
                    utilsManager4 = new UtilsManager();
                }
            }
        }
        return utilsManager4;
    }

    // 静态内部类 线程安全
    private static final class Instance{
        private static final UtilsManager utilsManager5= new UtilsManager();
    }
    public static UtilsManager getInstance5(){
        return Instance.utilsManager5;
    }

    // 枚举单例 线程安全
    public enum UtilsEmui{
        INSTANCE;
        public void funtion(){
            SystemOutputUtils.println("枚举单例");
        }
    }
    public static UtilsEmui getInstance6(){
     //   UtilsEmui.INSTANCE.funtion();
        return UtilsEmui.INSTANCE;
    }
}
