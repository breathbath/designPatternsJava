package com.observer;

/**
 * Created by breathbath on 01.04.15.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private WeatherData data;

    @Override
    public void display() {
        System.out.println("<------------------------>");
        System.out.println(
            "Current conditions: " +
            this.data.getTemperature() + " C " +
            this.data.getPressure() + " mm " +
            this.data.getHumidity() + "%"
        );
    }

    @Override
    public void update(WeatherData data) {
        this.data = data;
        display();
    }
}
