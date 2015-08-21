package com.abstractfactory;

public class ProductPrice {

    private String productId;

    private String price;

    public ProductPrice(String id, String price) {
        this.productId = id;
        this.price = price;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPrice() {
        return price;
    }
}
