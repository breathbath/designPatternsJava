package com.abstractfactory;

public class MockLog implements LogService{

    private String name;

    public MockLog(String name) {
        this.name = name;
    }

    @Override
    public void log(String message) {
        System.out.println(this.name + " has logged: " + message);
    }
}
