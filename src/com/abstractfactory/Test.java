package com.abstractfactory;

public class Test {

    public static void main(String[] args) {
        ServicesFactory abstractFactory = new FsBasedServicesFactory();
        ProductImporter importer = new ProductImporter(abstractFactory);
        importer.importProducts();

        abstractFactory = new CloudBasedServicesFactory();
        importer = new ProductImporter(abstractFactory);
        importer.importProducts();
    }


}
