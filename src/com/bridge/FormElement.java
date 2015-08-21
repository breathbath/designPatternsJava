package com.bridge;

abstract public class FormElement implements ThemeAppliable {

    private String font;
    private String color;
    private Theme theme;

    abstract protected void draw();

    public FormElement(Theme theme) {
        theme.applyTheme(this);
    }

    public void onClick() {
        System.out.println("Handling onclick event");
    }

    @Override
    public void setFont(String name) {
        this.font = name;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public void setTheme(Theme theme) {
        theme.applyTheme(this);
    }
}
