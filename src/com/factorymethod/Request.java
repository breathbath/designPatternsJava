package com.factorymethod;

import java.util.HashMap;

public class Request {

    private HashMap<String,String> requestData;

    public Request(HashMap<String,String> requestData){
        this.requestData = requestData;
    }

    public String getParam(String paramName) {
        return this.requestData.get(paramName);
    }
}
