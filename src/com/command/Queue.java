package com.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Queue implements QueueInterface {

    private ArrayList<HashMap<String, String>> data;

    public Queue() {
        this.data = new ArrayList<HashMap<String, String>>();
    }

    @Override
    public Integer add(String id, String message) {
        HashMap<String, String> messageInternal = new HashMap<String, String>();
        messageInternal.put(id, message);
        this.data.add(messageInternal);
        Integer index = this.data.size()-1;

        System.out.println("Queued message with id " + String.valueOf(index) + " with order id = <" + id + ">:");
        System.out.println("Message context: \"" + message + "\"");
        System.out.println();

        return index;
    }

    @Override
    public boolean remove(Integer key) {
        HashMap<String, String> message = this.data.get(key);
        Map.Entry<String,String> entry = message.entrySet().iterator().next();
        System.out.println("Removing message with id " + String.valueOf(key) + " with order id = <" + entry.getKey() + "> from the queue:");
        System.out.println("Message context: \"" + entry.getValue() + "\"");
        System.out.println();

        this.data.remove((int) key);

        return true;
    }
}
