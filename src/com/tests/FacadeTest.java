package com.tests;

import com.facade.CalculationFacade;
import com.facade.Product;
import junit.framework.TestCase;

public class FacadeTest extends TestCase {

    public void testFacade()
    {
        CalculationFacade facade = new CalculationFacade();
        Product product;

        product = facade.calculate(new Product("123", "food", 1000, "EUR"));
        assertEquals(1428, (int) product.getPrice());

        product = facade.calculate(new Product("124", "food", 1000, "USD"));
        assertEquals(1285, (int) product.getPrice());

        product = facade.calculate(new Product("125", "electronics", 1000, "EUR"));
        assertEquals(1309, (int) product.getPrice());

        product = facade.calculate(new Product("126", "someUnknownCategory", 1000, "EUR"));
        assertEquals(1309, (int) product.getPrice());

        product = facade.calculate(new Product("fx78", "someUnknownCategory", 1000, "EUR"));
        assertEquals(500, (int) product.getPrice());
    }
}
