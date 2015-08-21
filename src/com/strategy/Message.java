package com.strategy;

/**
 * Created by breathbath on 29.03.15.
 */
public class Message {
    private String title;

    private String body;

    public Message(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
