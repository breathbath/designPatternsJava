package com.observer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StatisticDisplay implements Observer, DisplayElement {

    private ArrayList<WeatherData> statistics;
    private HashMap<String, Float> min;
    private HashMap<String, Float> max;
    private HashMap<String, HashMap<String, Number>> avg;
    final public static String HUMIDITY = "humidity";
    final public static String TEMP = "temperature";
    final public static String PRESSURE = "pressure";


    public StatisticDisplay() {
        this.statistics = new ArrayList<WeatherData>();
        this.initStatistics();
    }

    @Override
    public void display() {
        System.out.println("<------------------------>");
        System.out.println("Min values: temperature: " + this.min.get(TEMP) + ", humidity: " + this.min.get(HUMIDITY) + ", pressure: " + this.min.get(PRESSURE));
        System.out.println("Max values: temperature: " + this.max.get(TEMP) + ", humidity: " + this.max.get(HUMIDITY) + ", pressure: " + this.max.get(PRESSURE));
        System.out.println("Avg values: temperature: " + this.avg.get(TEMP).get("avg") + ", humidity: "+ this.avg.get(HUMIDITY).get("avg") + ", pressure: " + this.avg.get(PRESSURE).get("avg"));
    }

    @Override
    public void update(WeatherData data) {
        this.statistics.add(data);
        this.collectStatistics();
        display();
    }

    private void collectStatistics(){
        this.initStatistics();
        for(WeatherData wd: statistics){
            this.updateMin(HUMIDITY, wd.getHumidity());
            this.updateMin(TEMP, wd.getTemperature());
            this.updateMin(PRESSURE, wd.getPressure());

            this.updateMax(HUMIDITY, wd.getHumidity());
            this.updateMax(TEMP, wd.getTemperature());
            this.updateMax(PRESSURE, wd.getPressure());

            this.updateSum(HUMIDITY, wd.getHumidity());
            this.updateSum(TEMP, wd.getTemperature());
            this.updateSum(PRESSURE, wd.getPressure());
        }

        for(Map.Entry<String, HashMap<String, Number>> entry : avg.entrySet()) {
            HashMap<String, Number> value = entry.getValue();
            Float sum = (Float) value.get("sum");
            Integer count = (Integer) value.get("count");
            Float avg = sum / count;
            value.put("avg", Math.round(avg));
        }
    }

    private void updateSum(String key, Float value){
        HashMap<String, Number> currVal = avg.get(key);
        HashMap<String, Number> newVal = new HashMap<String, Number>();
        Integer count = (Integer) currVal.get("count");
        newVal.put("count", ++count);
        Float sum = (Float) currVal.get("sum");
        newVal.put("sum", sum+value);

        avg.put(key, newVal);

    }

    private void updateMin(String key, Float value){
        if(min.get(key) == 0 || value < min.get(key)){
            min.put(key, value);
        }
    }

    private void updateMax(String key, Float value){
        if(max.get(key) < value){
            max.put(key, value);
        }
    }

    private void initStatistics(){
        min = new HashMap<String, Float>();
        max = new HashMap<String, Float>();
        avg = new HashMap<String, HashMap<String, Number>>();

        String[] measures = {TEMP, HUMIDITY, PRESSURE};

        HashMap<String, Number> hash = new HashMap<String, Number>();
        hash.put("sum", 0.0f);
        hash.put("count", 0);

        for(String param: measures){
            min.put(param, 0.0f);
            max.put(param, 0.0f);
            avg.put(param, hash);
        }
    }
}
