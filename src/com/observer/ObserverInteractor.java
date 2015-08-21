package com.observer;

public class ObserverInteractor implements WeatherDataOutput {

    private final WeatherStation weatherStation;

    public ObserverInteractor() {
        this.weatherStation = new WeatherStation();
        CurrentConditionsDisplay currDisplay = new CurrentConditionsDisplay();
        StatisticDisplay statDisplay = new StatisticDisplay();
        this.weatherStation.registerObserver(currDisplay);
        this.weatherStation.registerObserver(statDisplay);
    }

    @Override
    public void output(WeatherData data) {
        weatherStation.setMeasurements(data);
    }
}
