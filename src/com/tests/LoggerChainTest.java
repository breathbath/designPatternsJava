package com.tests;

import com.tests.mocks.chainresplogger.MockedOutput;
import junit.framework.*;
import com.chainresplogger.*;

public class LoggerChainTest extends TestCase {

    private AbstractLogger logger;
    private MockedOutput fileOutput;
    private MockedOutput serviceOutput;
    private MockedOutput consoleOutput;

    public void setUp() {
        this.fileOutput = new MockedOutput();
        this.serviceOutput = new MockedOutput();
        this.consoleOutput = new MockedOutput();

        AbstractLogger fileLogger = new Logger(AbstractLogger.ERROR, this.fileOutput);
        AbstractLogger serviceLogger = new Logger(AbstractLogger.INFO, this.serviceOutput);
        AbstractLogger consoleLogger = new Logger(AbstractLogger.WARNING, this.consoleOutput);
        fileLogger.setNextLogger(serviceLogger);
        serviceLogger.setNextLogger(consoleLogger);
        this.logger = fileLogger;
    }

    public void testErrorLogger() throws Exception {
        this.logger.logMessage(AbstractLogger.ERROR, "Something bad");
        assertEquals("Something bad", this.fileOutput.writtenMessage);
        assertTrue(this.serviceOutput.writtenMessage == null && this.consoleOutput.writtenMessage == null);
    }

    public void testWarningLogger() throws Exception {
        this.logger.logMessage(AbstractLogger.WARNING, "Something bad");
        assertEquals("Something bad", this.fileOutput.writtenMessage);
        assertEquals("Something bad", this.consoleOutput.writtenMessage);
        assertNull(this.serviceOutput.writtenMessage);
    }

    public void testInfoLogger() throws Exception {
        this.logger.logMessage(AbstractLogger.INFO, "Something bad");
        assertEquals("Something bad", this.fileOutput.writtenMessage);
        assertEquals("Something bad", this.serviceOutput.writtenMessage);
        assertEquals("Something bad", this.consoleOutput.writtenMessage);
    }
}
