package com.facade;

public class LocalConfigProvider implements ConfigProvider {

    @Override
    public Float getVat() {
        return Float.valueOf("0.19");
    }

    @Override
    public String getCurrency() {
        return "EUR";
    }
}
