package com.command;

public class TemplateConverter {
    private String templateId;

    public TemplateConverter(String templateId) {
        this.templateId = templateId;
    }

    public String convert(OrderContext orderContext) {
        return "Template " + this.templateId + " made message " + orderContext.getId() + " with date " + orderContext.getDate().toString();
    }
}
