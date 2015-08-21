package com.facade;

public class FixedPriceRule implements PriceRule {

    private FixedPriceProvider fixedPriceProvider;

    public FixedPriceRule() {
        this.fixedPriceProvider = new FixedPriceProvider();
    }

    @Override
    public Product applyRule(Product product) {
        Integer price = this.fixedPriceProvider.getFixedPrice(product);
        if(price != null){
            product.setPrice(price);
        }

        return product;
    }
}
