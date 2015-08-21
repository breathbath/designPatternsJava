package com.mediator;

public class Test {
    public static void main(String[] args){
        Exchange stockExchange = new Exchange();
        Client broker1 = new Broker(stockExchange, "broker1");
        Client broker2 = new Broker(stockExchange, "broker2");
        broker1.makeSaleOffer("MSFT", 100);
        broker1.makeSaleOffer("GOOG", 5);

        broker2.makeBuyOffer("MSFT", 100);
        broker2.makeSaleOffer("NRG", 50);

        broker1.makeBuyOffer("NRG", 50);

        stockExchange.getStockOfferings();
    }
}
