package com.factorymethod;

public class AboutControllerFactory extends Factory {

    public AboutControllerFactory(Request request) {
        super(request);
    }

    public Controller createController() {
        return new AboutController();
    }
}
