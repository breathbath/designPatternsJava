package com.facade;

import java.util.HashMap;

public class FixedPriceProvider {

    private HashMap<String, Integer> prices;

    public FixedPriceProvider() {
        HashMap<String, Integer>prices = new HashMap<>();
        prices.put("fx1", 1000);
        prices.put("fx10", 1500);
        prices.put("fx78", 500);
        this.prices = prices;
    }

    public Integer getFixedPrice(Product product){
        return this.prices.getOrDefault(product.getSku(), null);
    }

}
