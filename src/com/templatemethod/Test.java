package com.templatemethod;

/**
 * Created by breathbath on 30.03.15.
 */
public class Test {
    public static void main(String[] args){
        Tee tee = new Tee();
        Coffee coffee = new Coffee();
        tee.prepareRecipe();
        coffee.prepareRecipe();
    }
}
