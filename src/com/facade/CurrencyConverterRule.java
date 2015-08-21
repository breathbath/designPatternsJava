package com.facade;

public class CurrencyConverterRule implements PriceRule {

    private CurrencyRatesProvider currencyRatesProvider;
    private ConfigProvider configProvider;

    public CurrencyConverterRule(CurrencyRatesProvider currencyRatesProvider, ConfigProvider configProvider) {
        this.currencyRatesProvider = currencyRatesProvider;
        this.configProvider = configProvider;
    }

    public Product applyRule(Product product) {
        String shopCurrency = this.configProvider.getCurrency();
        String productCurrency = product.getCurrencyNetPrice();
        if(shopCurrency.equals(productCurrency)){
            product.setPrice(product.getPrice());
            return product;
        }

        Float rate = this.currencyRatesProvider.getRate(productCurrency, shopCurrency);
        Integer netPrice = product.getNetPrice();
        Float price = netPrice.floatValue() * rate;
        product.setPrice(price.intValue());

        return product;
    }
}
