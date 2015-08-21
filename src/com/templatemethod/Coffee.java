package com.templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coffee extends CoffeineBeverage {

    protected void addCondiments() {
        System.out.println(
                "Adding sugar and milk"
        );
    }

    protected void brew() {
        System.out.println(
                "Dripping coffee through filter"
        );
    }

    protected boolean customerWantsCondiments(){
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput(){
        String answer = null;
        System.out.println("Would you like milk and sugar with your coffee (y/n)?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            answer = in.readLine();
        }
        catch (IOException ioe){
            System.err.println("IO error trying to read your answer");
        }
        if(answer == null){
            return "no";
        }
        return answer;
    }

}
