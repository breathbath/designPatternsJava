package com.observer;

public class Test {

    public static void main(String[] args) {
        WeatherDataInput input = new UserDataInput();
        WeatherDataOutput output = new ObserverInteractor();
        while (true) {
            WeatherData data = input.readInput();
            if (data == null) {
                continue;
            }
            output.output(data);
        }
    }


}
