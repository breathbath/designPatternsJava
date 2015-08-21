package com.command;

import java.util.Date;

public class OrderContext {

    private String id;

    private Date date;

    private Integer QueuedId;

    public OrderContext(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Integer getQueuedId() {
        return QueuedId;
    }

    public void setQueuedId(Integer queuedId) {
        QueuedId = queuedId;
    }

    public boolean equals(OrderContext obj) {
        return this.id.equals(obj.getId());
    }
}
