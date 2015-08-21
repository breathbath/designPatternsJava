package com.tests.mocks.chainresplogger;

import com.chainresplogger.OutputInterface;

public class MockedOutput implements OutputInterface {

    public String writtenMessage;

    @Override
    public void write(String message) {
        this.writtenMessage = message;
    }
}
