package com.abstractfactory;

public class CloudBasedServicesFactory implements ServicesFactory {

    @Override
    public CacheService createCacheService() {
        return new MockCache("Remote cache service");
    }

    @Override
    public LogService createLogService() {
        return new MockLog("Remote queue based log service");
    }

    @Override
    public ProductStorageService createStorageService() {
        return new MockStorage("Remote api storage");
    }
}
