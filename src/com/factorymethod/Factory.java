package com.factorymethod;

public abstract class Factory {

    private final Request request;

    public Factory(Request request){
        this.request = request;
    }

    protected abstract Controller createController();

    public Controller create(){
        Controller controller = this.createController();
        controller.setRequest(this.request);

        return controller;
    }
}
