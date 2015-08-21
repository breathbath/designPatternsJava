package com.proxy;

import com.proxy.protection.Employee;
import com.proxy.protection.ImmutableEmployee;
import com.proxy.protection.EmployeeInterface;
import com.proxy.remote.SMRemoteProxy;
import com.proxy.rmi.server.OrderContext;
import com.proxy.rmi.server.States;
import com.proxy.virtual.Image;
import com.proxy.virtual.ProxyImage;
import com.proxy.virtual.RealImage;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        Employee manager = new Employee();
        manager.setName("Mal");
        manager.setAddress("123 Avenue, NY");
        printInvoice(manager, 1000);

        ImmutableEmployee deliveryBoy = new ImmutableEmployee("Paul", "324 Happy Bvd.");
        printInvoice(deliveryBoy, 100);

        final Image image2 = new RealImage("File2");
        image2.displayImage();
        final Image image1 = new ProxyImage("File1");
        image1.displayImage();
        final Image image3 = new RealImage("File2");
        image3.displayImage();
        image1.displayImage();

        OrderContext orderContext = new OrderContext();
        orderContext.setState(States.NEW);
        SMRemoteProxy proxySm = new SMRemoteProxy();
        OrderContext newOrderContext = proxySm.calculateNextState(orderContext);
        System.out.println("New order state is: " + newOrderContext.getState());
    }

    private static String convertToInvoiceSting(EmployeeInterface employee, Integer salary){
        String name = employee.getName();
        name = "Salary to "+ name + " (" + employee.getAddress() + "): " + salary;
        employee.setName(name);

        return name;
    }

    private static void printInvoice(EmployeeInterface employee, Integer salary){
        System.out.println();
        System.out.println("Printing invoice");
        System.out.println(convertToInvoiceSting(employee, salary));
        System.out.println("----------------");
        System.out.println("Subscribed by " + employee.getName());
    }

}
