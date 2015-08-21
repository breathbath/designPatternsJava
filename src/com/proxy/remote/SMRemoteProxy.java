package com.proxy.remote;

import com.proxy.rmi.server.OrderContext;
import com.proxy.rmi.server.StateMachine;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SMRemoteProxy implements StateMachine {

    @Override
    public OrderContext calculateNextState(OrderContext order) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "SM";
            Registry registry = LocateRegistry.getRegistry(1099);
            StateMachine remoteSM = (StateMachine) registry.lookup(name);
            return remoteSM.calculateNextState(order);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
        return null;
    }
}
