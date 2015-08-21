package com.facade;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<PriceRule> rules = new ArrayList<>();

    public void addPriceRule(PriceRule rule){
        this.rules.add(rule);
    }

    public Product calculatePrice(Product product){
        if(this.rules == null){
            return product;
        }
        System.out.println("--------------------------------------------");
        System.out.println("Starting calculation of : " + product.getSku());
        for(PriceRule rule : this.rules){
            product = rule.applyRule(product);
            System.out.println("New price after " + rule.getClass().getTypeName() + " :" + product.getPrice());
        }

        System.out.println("--------------------------------------- Total: " + product.getPrice());
        return product;
    }
}
