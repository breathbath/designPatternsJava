package com.bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadioButton<K, String> extends FormElement {

    private String title;

    private HashMap<K, String> options;

    public RadioButton(String title, HashMap<K, String> options, Theme theme) {
        super(theme);
        this.title = title;
        this.options = options;
    }

    @Override
    protected void draw() {
        System.out.println("Drawing radio " + this.title + " font: " + this.getFont() + ", color: " + this.getColor());
        System.out.println("Options:");
        for(Map.Entry<K, String> option : this.options.entrySet()) {
            System.out.println("<" + java.lang.String.valueOf(option.getKey()) + ">: " + option.getValue() + ";");
        }
    }

}
