package com.facade;

public class CalculationFacade {

    private PriceCalculator priceCalculator;

    public CalculationFacade() {
        PriceCalculator priceCalculator = new PriceCalculator();

        ConfigProvider configProvider = new LocalConfigProvider();
        CurrencyRatesProvider ratesProvider = new LocalExchangeRates();

        PriceRule exchangeRule = new CurrencyConverterRule(ratesProvider, configProvider);
        priceCalculator.addPriceRule(exchangeRule);

        PriceRule vatRule = new VatRule(configProvider);
        priceCalculator.addPriceRule(vatRule);

        priceCalculator.addPriceRule(new MarginRule());

        priceCalculator.addPriceRule(new FixedPriceRule());

        this.priceCalculator = priceCalculator;
    }

    public Product calculate(Product product){
        return this.priceCalculator.calculatePrice(product);
    }
}
