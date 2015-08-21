package com.tests;

import com.chainofresponibility.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class ChainExceptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testFailure() throws Exception {
        Chain last = new Multiplication();
        last.setNextChain(new Division());

        Chain sub = new Subtraction();
        sub.setNextChain(last);

        Chain first = new Addition();
        first.setNextChain(sub);

        exception.expect(UnknownOperationException.class);
        exception.expectMessage("Unsupported command lalala");

        first.calculate(new CalculationRequest(1,1,"lalala"));
    }

}
