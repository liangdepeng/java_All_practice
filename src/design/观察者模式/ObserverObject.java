package design.观察者模式;

import java.util.ArrayList;

public class ObserverObject {

    private final ArrayList<Observer> observers;

    public ObserverObject() {
        observers = new ArrayList<>();
    }

    public void addObserverObj(Observer obj) {
        observers.add(obj);
    }

    public void removeObserverObj(Observer obj) {
        observers.remove(obj);
    }

    public void notifyAllObservers(int newData) {
        for (Observer observer : observers) {
            observer.update(newData);
        }
    }
}
