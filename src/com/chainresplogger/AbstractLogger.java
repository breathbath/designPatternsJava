package com.chainresplogger;

public abstract class AbstractLogger {

    public static int INFO = 3;

    public static int WARNING = 2;

    public static int ERROR = 1;

    private AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    public void logMessage (int level, String message){
        if(this.getCurrentLevel() <= level){
            this.getOutput().write(message);
        }
        if(this.nextLogger != null){
            this.nextLogger.logMessage(level, message);
        }
    }

    protected abstract OutputInterface getOutput();

    protected abstract int getCurrentLevel();
}
