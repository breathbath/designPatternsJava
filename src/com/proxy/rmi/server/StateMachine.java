package com.proxy.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StateMachine extends Remote {

    public OrderContext calculateNextState(OrderContext order) throws RemoteException;

}
