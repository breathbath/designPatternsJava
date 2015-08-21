package com.facade;

public class VatRule implements PriceRule {

    private ConfigProvider configProvider;

    public VatRule(ConfigProvider configProvider) {
        this.configProvider = configProvider;
    }

    @Override
    public Product applyRule(Product product) {
        Float vat = this.configProvider.getVat();
        Integer price = product.getPrice();
        Float grossPrice = (1+vat) * price;
        product.setPrice(grossPrice.intValue());
        return product;
    }
}
