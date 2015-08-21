package com.command;

public class OrderNotifier implements OrderNotificationCommand {
    private TemplateConverter template;
    private QueueInterface queue;

    public OrderNotifier(TemplateConverter template, QueueInterface queue) {
        this.template = template;
        this.queue = queue;
    }

    @Override
    public void notify(OrderContext orderContext) {
        String message = this.template.convert(orderContext);
        Integer queuedMessageId = this.queue.add(orderContext.getId(), message);
        orderContext.setQueuedId(queuedMessageId);
    }

    @Override
    public void undoNotification(OrderContext orderContext) {
        this.queue.remove(orderContext.getQueuedId());
    }
}
