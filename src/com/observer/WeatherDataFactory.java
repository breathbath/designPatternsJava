package com.observer;

import java.util.Date;

public class WeatherDataFactory {

    public static WeatherData create(float temp, float humidity, float pressure){
        WeatherData $wd = new WeatherData();
        return $wd.setHumidity(humidity).setTemperature(temp).setPressure(pressure);
    }

    public static WeatherData create(float temp, float humidity, float pressure, Date timestamp){
        WeatherData $wd = new WeatherData();
        return $wd.setHumidity(humidity).setTemperature(temp).setPressure(pressure).setTimestamp(timestamp);
    }
}
