package com.observer;

import java.util.Date;

public class WeatherData {

    private float temperature;

    private float pressure;

    private float humidity;

    private Date timestamp;

    public float getTemperature() {
        return temperature;
    }

    public WeatherData setTemperature(float temperature) {
        this.temperature = temperature;
        return this;
    }

    public float getPressure() {
        return pressure;
    }

    public WeatherData setPressure(float pressure) {
        this.pressure = pressure;
        return this;
    }

    public float getHumidity() {
        return humidity;
    }

    public WeatherData setHumidity(float humidity) {
        this.humidity = humidity;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public WeatherData setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public boolean isValid() {
        return (this.humidity != 0 && this.pressure != 0 && this.temperature !=0);
    }

    public String toString(){
        return this.timestamp+": humidity = "+this.humidity + " temperature = " + this.temperature + " pressure = " + this.pressure;
    }
}
