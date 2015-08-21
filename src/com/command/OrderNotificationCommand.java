package com.command;

/**
 * Created by breathbath on 15.04.15.
 */
public interface OrderNotificationCommand {

    public void notify(OrderContext orderContext);

    public void undoNotification(OrderContext orderContext);
}
