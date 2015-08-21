package com.tests.mocks.strategy;

import com.strategy.Message;
import com.strategy.NotificationChannel;
import com.strategy.Storage;

public class StorageMock implements Storage {

    private final String type;

    private boolean storingResult = true;

    public Message storedMessage;

    public StorageMock(String $type){
        this.type = $type;
    }

    public StorageMock(String $type, boolean storingResult){
        this.type = $type;
        this.storingResult = storingResult;
    }

    @Override
    public boolean save(Message $message) {
        System.out.println("Storing message " + $message.getTitle() + " in " + this.type);
        this.storedMessage = $message;
        return this.storingResult;
    }
}
