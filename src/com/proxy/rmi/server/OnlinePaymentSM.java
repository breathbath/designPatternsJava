package com.proxy.rmi.server;

import java.rmi.RemoteException;

public class OnlinePaymentSM implements StateMachine {

    @Override
    public OrderContext calculateNextState(OrderContext order) throws RemoteException {
        if (order.getState().equals(States.NEW)) {
            order.setState(States.CLOSED);
        }
        return order;
    }
}
