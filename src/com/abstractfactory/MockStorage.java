package com.abstractfactory;

public class MockStorage implements ProductStorageService{
    private String name;

    public MockStorage(String name) {
        this.name = name;
    }

    @Override
    public Product getById(String id) {
        Product product = new Product();
        product.setId(id);
        product.setPrice("000");
        product.setName("productName");
        product.setDescription("product description");

        return product;
    }

    @Override
    public void save(Product product) {
        System.out.println(this.name + " saved product with id " + product.getId());
    }
}
