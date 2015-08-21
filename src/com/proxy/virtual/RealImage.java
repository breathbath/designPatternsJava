package com.proxy.virtual;

public class RealImage implements Image {

    private String filename = null;

    public RealImage(final String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Accessing fs to load image " + this.filename);
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying image: " + this.filename);
    }
}
