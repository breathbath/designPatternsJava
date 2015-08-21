package com.proxy.protection;

public interface EmployeeInterface {

    public String getName();

    public void setName(String name);

    public String getAddress();

    public void setAddress(String address);

    public void copyFrom(Employee employee);
}
