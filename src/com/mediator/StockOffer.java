package com.mediator;

/**
 * Created by breathbath on 31.03.15.
 * Object encapsulates the offer for the stock - who, what and how much
 */
public class StockOffer {

    private int stockShares = 0;

    private String stockSymbol = "";

    private String clientCode = "";

    public StockOffer(int stockShares, String stockSymbol, String clientCode) {
        this.stockShares = stockShares;
        this.stockSymbol = stockSymbol;
        this.clientCode = clientCode;
    }

    public int getStockShares() {
        return stockShares;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getClientCode() {
        return clientCode;
    }

    public boolean equals(StockOffer offer){
        return this.getStockSymbol().equals(offer.getStockSymbol()) && this.getStockShares() == offer.getStockShares();
    }
}
