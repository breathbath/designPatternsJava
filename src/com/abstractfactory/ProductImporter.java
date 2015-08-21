package com.abstractfactory;

import java.util.ArrayList;

public class ProductImporter {

    private ServicesFactory abstractServicesFactory;

    public ProductImporter(ServicesFactory $abstractServicesFactory) {
        this.abstractServicesFactory = $abstractServicesFactory;
    }

    protected ArrayList<ProductPrice> loadPrices(){
        ArrayList<ProductPrice> prices = new ArrayList<ProductPrice>();
        prices.add(new ProductPrice("1", "111"));
        prices.add(new ProductPrice("2", "222"));
        return prices;
    };

    public void importProducts(){
        ArrayList<ProductPrice> productPrices = this.loadPrices();
        CacheService cache = this.abstractServicesFactory.createCacheService();
        ProductContextConverter converter = new ProductContextConverter();

        ProductStorageService storage = this.abstractServicesFactory.createStorageService();

        LogService log = this.abstractServicesFactory.createLogService();

        for (ProductPrice productPrice : productPrices){
            Product product = null;

            if(cache.exists(productPrice.getProductId())){
                String productSerialised = cache.get(productPrice.getProductId());
                product = converter.toProduct(productSerialised);
                log.log("Got product with id "+productPrice.getProductId()+" from cache");
            }
            else{
                product = storage.getById(productPrice.getProductId());
                if(product == null){
                    log.log("Product with id "+productPrice.getProductId() + " not found in persistent storage");
                    continue;
                }
                log.log("Got product with id " + productPrice.getProductId() + " from persistent storage");
                cache.save(productPrice.getProductId(), converter.fromProduct(product));
                log.log("Cached product with id " + productPrice.getProductId());
            }

            product.setPrice(productPrice.getPrice());
            log.log("Set price " + productPrice.getPrice() + " to product with id " + productPrice.getProductId());
            storage.save(product);
            log.log("Saved product with id " + productPrice.getProductId() + " in the persistent storage");
        }
    }



}
