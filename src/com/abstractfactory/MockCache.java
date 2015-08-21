package com.abstractfactory;

public class MockCache implements CacheService{
    private String name;

    public MockCache(String name) {
        this.name = name;
    }

    @Override
    public boolean exists(String key) {
        return true;
    }

    @Override
    public String get(String key) {
        return "some string";
    }

    @Override
    public void save(String key, String data) {
        System.out.println(this.name + "saved data with key "+ key + " as " + data);
    }
}
