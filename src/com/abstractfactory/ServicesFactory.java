package com.abstractfactory;

public interface ServicesFactory {

    public CacheService createCacheService();

    public LogService createLogService();

    public ProductStorageService createStorageService();
}
