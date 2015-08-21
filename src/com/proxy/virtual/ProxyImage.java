package com.proxy.virtual;

public class ProxyImage implements Image {

    private RealImage realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void displayImage() {
        if(this.realImage == null){
            this.realImage = new RealImage(this.fileName);
        }
        this.realImage.displayImage();
    }
}
