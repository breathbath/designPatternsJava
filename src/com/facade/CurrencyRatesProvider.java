package com.facade;

public interface CurrencyRatesProvider {

    public Float getRate(String currency1, String currency2);
}
