package com.chainresplogger;

/**
 * Created by breathbath on 29.03.15.
 */
public class FileOutput implements OutputInterface {

    @Override
    public void write(String message) {
        System.out.println("Writing to file: " + message);
    }
}
