package com.tests.mocks.strategy;
import com.strategy.*;

public class ChannelMock implements NotificationChannel {

    private final String type;

    private boolean sendingResult = true;

    public Message sentMessage;

    public ChannelMock(String $type){
        this.type = $type;
    }

    public ChannelMock(String $type, boolean sendingResult){
        this.type = $type;
        this.sendingResult = sendingResult;
    }

    @Override
    public boolean send(Message $message) {
        System.out.println("Sending message " + $message.getTitle() + " as " + this.type);
        this.sentMessage = $message;
        return this.sendingResult;
    }
}
