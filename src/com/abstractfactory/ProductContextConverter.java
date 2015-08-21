package com.abstractfactory;

public class ProductContextConverter {

    /**
     * TODO real implemenation for deserialisation
     */
    public Product toProduct(String productContext){
        Product product = new Product();
        product.setId("1");
        product.setDescription("description");
        product.setName("product-name");
        product.setPrice("000");
        return product;
    }

    public String fromProduct(Product product){
        return product.toString();
    }
}
