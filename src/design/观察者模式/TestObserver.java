package design.观察者模式;

public class TestObserver {

    public static void main(String[] args) {
        Shop1 shop1 = new Shop1();
        Shop2 shop2 = new Shop2();
        Shop3 shop3 = new Shop3();

        ObserverObject observerObject = new ObserverObject();
        observerObject.addObserverObj(shop1);
        observerObject.addObserverObj(shop2);
        observerObject.addObserverObj(shop3);

        observerObject.notifyAllObservers(100);
        observerObject.removeObserverObj(shop2);
        observerObject.notifyAllObservers(200);

    }
}
