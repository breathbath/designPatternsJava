package com.bridge;

public class SkyBlueTheme implements Theme {

    @Override
    public void applyTheme(ThemeAppliable target) {
        target.setColor("sky-blue");
        target.setFont("Helvetica regular 16px blue");
    }
}
