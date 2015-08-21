package com.bridge;

import com.sun.tools.corba.se.idl.AttributeEntry;
import com.templatemethod.Coffee;
import com.templatemethod.Tee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by breathbath on 30.03.15.
 */
public class Test {
    public static void main(String[] args){
        Button button = new Button("Start something button", new ClassicTheme());
        button.draw();
        button.onClick();

        HashMap<Integer,String> options = new HashMap<Integer, String>();
        options.put(1, "One");
        options.put(2, "Two");
        options.put(3, "Three");

        RadioButton radio = new RadioButton("Select something dropdown", options, new ClassicTheme());
        radio.draw();
        radio.onClick();

        button.setTheme(new SkyBlueTheme());
        button.draw();

        radio.setTheme(new SkyBlueTheme());
        radio.draw();

        /**
         * I can add new Form elements without affecting the theme hierarchy
         * The same for theme - I can introduce new themes without changing the form elements
         */
    }
}
