package com.mediator;

/**
 * Created by breathbath on 31.03.15.
 */
public class Broker extends Client {

    public Broker(Mediator mediator, String name) {
        super(mediator, name);
        System.out.println(name + " singed up for exchange");
    }
}
