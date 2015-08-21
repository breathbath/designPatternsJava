package com.bridge;

public class Button extends FormElement {

    private String title;

    public Button(String title, Theme theme) {
        super(theme);
        this.title = title;
    }

    @Override
    protected void draw() {
        System.out.println("Drawing button " + this.title + " font: "+ this.getFont() + ", color: "+ this.getColor());
    }
}
