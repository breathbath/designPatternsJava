package com.chainresplogger;

public class Logger extends AbstractLogger {
    private final OutputInterface output;

    private final int level;

    public Logger(int level, OutputInterface output) {
        this.level = level;
        this.output = output;
    }

    @Override
    protected OutputInterface getOutput() {
        return this.output;
    }

    @Override
    protected int getCurrentLevel() {
        return this.level;
    }
}
