package com.facade;

public class Product {

    private String sku;

    private Integer price;

    private String category;

    private Integer netPrice;

    private String currencyNetPrice;

    public Product(String sku, String category, Integer netPrice, String currencyNetPrice) {
        this.sku = sku;
        this.category = category;
        this.netPrice = netPrice;
        this.currencyNetPrice = currencyNetPrice;
        this.price = netPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getCategory() {
        return category;
    }

    public Integer getNetPrice() {
        return netPrice;
    }

    public String getCurrencyNetPrice() {
        return currencyNetPrice;
    }
}
