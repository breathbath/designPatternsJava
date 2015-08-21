package com.mediator;

/**
 * Created by breathbath on 31.03.15.
 */
public abstract class Client {

    private final String name;

    private Mediator mediator;

    public Client(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public void makeSaleOffer(String stock, int shares){
        mediator.saleOffer (new StockOffer (shares, stock, this.name));
    }


    public void makeBuyOffer(String stock, int shares){
        mediator.buyOffer(new StockOffer (shares, stock, this.name));
    }

    public String getName(){
        return this.name;
    }
}
