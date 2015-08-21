package com.factorymethod;

public class IndexControllerFactory extends Factory {

    public IndexControllerFactory(Request request) {
        super(request);
    }

    public Controller createController() {
        return new IndexController();
    }
}
