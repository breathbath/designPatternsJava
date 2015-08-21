package com.command;

/**
 * Created by breathbath on 15.04.15.
 */
public interface QueueInterface {

    public Integer add(String id, String message);
    public boolean remove(Integer id);
}
