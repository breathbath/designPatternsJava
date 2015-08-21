package com.factorymethod;

public class AboutController extends Controller {
    public void action(){
        this.getResponse().setBody("Index action about controller");
        this.getResponse().setHeaders("Index headers");
    }
}
