package com.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

    public static String getUserInput(String inputQuestion){
        String answer = null;
        System.out.println(inputQuestion);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            answer = in.readLine();
        }
        catch (IOException ioe){
            System.err.println("IO error trying to read your answer");
        }
        return answer;
    }
}
