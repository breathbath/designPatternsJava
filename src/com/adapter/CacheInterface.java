package com.adapter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CacheInterface {

    public void add(String key, String data, int timeout) throws IOException;

    public String get(String key) throws IOException;

    public void delete(String key);

    public boolean exists(String key);

}
