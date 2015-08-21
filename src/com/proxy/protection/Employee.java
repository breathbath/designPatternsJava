package com.proxy.protection;

public class Employee implements EmployeeInterface {
    String name;
    String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void copyFrom(Employee employee) {
        this.name = employee.getName();
        this.address = employee.getAddress();
    }
}
