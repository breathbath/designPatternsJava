package com.factorymethod;

public class IndexController extends Controller {

    public void action(){
        this.getResponse().setBody("Index action index controller");
        this.getResponse().setHeaders("Index headers 1,2,3");
    }
}
