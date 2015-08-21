package com.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserDataInput implements WeatherDataInput {

    private ArrayList<Float> numberInput;

    public UserDataInput() {
        this.numberInput = new ArrayList<Float>();
    }

    public WeatherData readInput() {
        String input= UserInput.getUserInput("Enter new values for temperature, humidity and pressure as comma separated values (20,90,110); Enter exit (e) to close");
        if(input.equals("exit") || input.equals("e")){
            System.exit(0);
        }
        if(parseInput(input)){
            return WeatherDataFactory.create(this.numberInput.get(0), this.numberInput.get(1), this.numberInput.get(2));
        }
        else{
            return null;
        }
    }

    private boolean parseInput(String inputString){
        this.numberInput = new ArrayList<Float>();
        String[] result = inputString.split(",");
        if(result.length != 3){
            System.err.println("Wrong format or missing one value");
            return false;
        }
        try {
            for (String value : result) {
                Float numbValue = Float.valueOf(value);
                this.numberInput.add(numbValue);
            }
        }
        catch (NumberFormatException e){
            System.err.println("One of the values has not a number format");
            return false;
        }
        return true;
    }
}
