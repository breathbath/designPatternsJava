package com.facade;

import java.util.HashMap;

public class MarginRule implements PriceRule {
    private HashMap<String, Double> margins;

    public MarginRule() {
        HashMap<String, Double> margins = new HashMap<>();
        margins.put("electronics", 0.1);
        margins.put("food", 0.2);
        margins.put("toys", 0.3);
        margins.put("default", 0.1);
        this.margins = margins;
    }

    public Product applyRule(Product product) {
        Integer price = product.getPrice();
        Double margin = this.margins.getOrDefault(product.getCategory(), this.margins.get("default"));
        Double grossPrice = price * (1+margin);
        product.setPrice(grossPrice.intValue());
        return product;
    }
}
