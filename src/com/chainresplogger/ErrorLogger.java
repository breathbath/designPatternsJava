package com.chainresplogger;

public class ErrorLogger extends AbstractLogger {

    private final OutputInterface output;

    /**
     * @param output OutputInterface
     */
    public ErrorLogger(OutputInterface output) {
        this.output = output;
    }

    @Override
    protected OutputInterface getOutput() {
        return this.output;
    }

    @Override
    protected int getCurrentLevel() {
        return ERROR;
    }
}
