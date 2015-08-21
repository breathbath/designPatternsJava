package com.observer;

import java.util.ArrayList;
import java.util.Date;

public class WeatherStation implements Subject {
    private ArrayList<Observer> observers;
    private WeatherData data;

    public WeatherStation() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers){
            observer.update(this.data);
        }
    }

    public void setMeasurements(WeatherData data){
        data.setTimestamp(new Date());
        this.data = data;
        notifyObservers();
    }
}
