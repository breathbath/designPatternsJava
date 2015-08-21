package com.abstractfactory;

public class FsBasedServicesFactory implements ServicesFactory {

    @Override
    public CacheService createCacheService() {
        return new MockCache("Fs based cache service");
    }

    @Override
    public LogService createLogService() {
        return new MockLog("Fs based log service");
    }

    @Override
    public ProductStorageService createStorageService() {
        return new MockStorage("Db based storage");
    }
}
