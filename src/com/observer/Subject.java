package com.observer;

/**
 * Created by breathbath on 01.04.15.
 */
public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
