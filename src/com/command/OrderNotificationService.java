package com.command;

public class OrderNotificationService {
    private OrderNotificationCommand command;

    public OrderNotificationService(OrderNotificationCommand command) {
        this.command = command;
    }

    public void setCommand(OrderNotificationCommand command) {
        this.command = command;
    }

    public void notifyAboutOrder(OrderContext context){
        this.command.notify(context);
    }

    public void resetOrderNotification(OrderContext context) {
        this.command.undoNotification(context);
    }
}
