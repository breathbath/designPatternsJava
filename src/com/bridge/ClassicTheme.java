package com.bridge;

public class ClassicTheme implements Theme {

    @Override
    public void applyTheme(ThemeAppliable target) {
        target.setColor("gray");
        target.setFont("Arial regular 16px black");
    }
}
