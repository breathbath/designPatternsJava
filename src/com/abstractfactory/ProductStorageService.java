package com.abstractfactory;

/**
 * Created by breathbath on 03.05.15.
 */
public interface ProductStorageService {

    public Product getById(String id);

    public void save(Product product);
}
