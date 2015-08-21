package com.adapter;

public class MemcacheCache implements CacheInterface {

    @Override
    public void add(String key, String data, int timeout) {
    }

    @Override
    public String get(String key) {
        return "";
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public boolean exists(String key) {
        return true;
    }
}
