package com.command;

import java.util.Date;

public class Test {
    public static void main(String[] args){
        Queue queue = new Queue(); //external service dependency
        OrderContext order = new OrderContext("1", new Date()); //entity

        TemplateConverter newOrderTemplate = new TemplateConverter("newOrderTemplate"); //converted order to string message
        OrderNotificationCommand newOrderNotification = new OrderNotifier(newOrderTemplate, queue); //command itself

        OrderNotificationService notificationService = new OrderNotificationService(newOrderNotification); //command executor
        notificationService.notifyAboutOrder(order); //command execution

        System.out.println("Pity( - order was canceled");
        notificationService.resetOrderNotification(order); //undo execution of the command

        TemplateConverter orderPaidTemplate = new TemplateConverter("orderPaidTemplate");
        OrderNotificationCommand orderPaidNotification = new OrderNotifier(orderPaidTemplate, queue);

        notificationService.setCommand(orderPaidNotification);
        notificationService.notifyAboutOrder(order);

        TemplateConverter orderDeliveringTemplate = new TemplateConverter("orderDeliveringTemplate");
        OrderNotificationCommand orderDeliveringNotification = new OrderNotifier(orderDeliveringTemplate, queue);

        notificationService.setCommand(orderDeliveringNotification);
        notificationService.notifyAboutOrder(order);



    }
}
