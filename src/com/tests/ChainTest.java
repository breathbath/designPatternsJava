package com.tests;

import com.chainofresponibility.*;
import junit.framework.*;

public class ChainTest extends TestCase {

    private Chain calculator;

    public void setUp() {
        Chain mult = new Multiplication();
        mult.setNextChain(new Division());

        Chain sub = new Subtraction();
        sub.setNextChain(mult);

        Chain add = new Addition();
        add.setNextChain(sub);

        this.calculator = add;
    }

    public void testAddition() throws Exception {
        CalculationRequest request = new CalculationRequest(1, 2, "add");
        assertEquals(3, this.calculator.calculate(request));
    }

    public void testSubtraction() throws Exception {
        CalculationRequest request = new CalculationRequest(1, 2, "sub");
        assertEquals(-1, this.calculator.calculate(request));
    }

    public void testMultiplication() throws Exception {
        CalculationRequest request = new CalculationRequest(10, 2, "mult");
        assertEquals(20, this.calculator.calculate(request));
    }

    public void testDivision() throws Exception {
        CalculationRequest request = new CalculationRequest(10, 2, "div");
        assertEquals(5, this.calculator.calculate(request));
    }

}
