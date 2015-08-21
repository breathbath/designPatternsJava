package com.abstractfactory;

/**
 * Created by breathbath on 03.05.15.
 */
public interface CacheService {

    public boolean exists(String key);

    public String get(String key);

    public void save(String key, String data);
}
