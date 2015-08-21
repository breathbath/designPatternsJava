package com.proxy.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SMServer {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "SM";
            StateMachine sm = new OnlinePaymentSM();
            StateMachine stub = (StateMachine) UnicastRemoteObject.exportObject(sm, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("SM bound");
        } catch (RemoteException e) {
            System.err.println("SM exception:");
            e.printStackTrace();
        }
    }

}
