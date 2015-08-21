package com.facade;

public class LocalExchangeRates implements CurrencyRatesProvider {


    @Override
    public Float getRate(String currency1, String currency2) {
        if(currency1.equals("EUR") && currency2.equals("USD")){
            return Float.valueOf("1.1");
        }
        if(currency1.equals("USD") && currency2.equals("EUR")){
            return Float.valueOf("0.9");
        }

        return Float.valueOf("1");
    }
}
