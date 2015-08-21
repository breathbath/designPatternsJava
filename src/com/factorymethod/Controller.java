package com.factorymethod;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Controller {

    private Request request;

    private Response response;

    public Controller(){
        this.response = new Response();
    }

    protected abstract void action();

    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }
}
