package com.templatemethod;

/**
 * Created by breathbath on 30.03.15.
 */
public class Tee extends CoffeineBeverage{

    protected void brew() {
        System.out.println("Steeping the tea");
    }

    protected void addCondiments() {
        System.out.println("Adding lemon");
    }

}
