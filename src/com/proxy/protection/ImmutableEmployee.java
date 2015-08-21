package com.proxy.protection;

public class ImmutableEmployee implements EmployeeInterface {
    private Employee employee;

    public ImmutableEmployee(String name, String address) {
        this.employee = new Employee();
        this.employee.setName(name);
        this.employee.setAddress(address);
    }

    @Override
    public String getName() {
        return this.employee.getName();
    }

    @Override
    public String getAddress() {
        return this.employee.getAddress();
    }

    public void setName(String name) {
        System.out.println("Cannot set immutable value");
    }

    @Override
    public void setAddress(String address) {
        System.out.println("Cannot set immutable value");
    }

    @Override
    public void copyFrom(Employee employee) {
        System.out.println("Cannot set immutable value");
    }
}
