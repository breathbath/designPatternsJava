package com.mediator;

import java.util.ArrayList;

public class Exchange implements Mediator {

    private ArrayList<StockOffer> saleOffers;

    private ArrayList<StockOffer> buyOffers;

    public Exchange() {
        saleOffers = new ArrayList<StockOffer>();
        buyOffers = new ArrayList<StockOffer>();
    }

    @Override
    public void saleOffer(StockOffer stockOffer) {
        boolean stockSold = false;
        for (StockOffer buyOffer: buyOffers){
            if(buyOffer.equals(stockOffer)){
                System.out.println(stockOffer.getStockShares() + " shares of " + stockOffer.getStockSymbol() + " sold to " + buyOffer.getClientCode());
                buyOffers.remove(buyOffer);
                stockSold = true;
                break;
            }
        }

        if(!stockSold){
            System.out.println(stockOffer.getStockShares() + " share of " + stockOffer.getStockSymbol() + " added to inventory");
            saleOffers.add(stockOffer);
        }
    }

    @Override
    public void buyOffer(StockOffer stockOffer) {
        boolean stockBought = false;
        for (StockOffer saleOffer: saleOffers){
            if(saleOffer.equals(stockOffer)){
                System.out.println(stockOffer.getStockShares() + " shares of " + stockOffer.getStockSymbol() + " bought by " + saleOffer.getClientCode());
                saleOffers.remove(saleOffer);
                stockBought = true;
                break;
            }
        }

        if(!stockBought){
            System.out.println(stockOffer.getStockShares() + " share of " + stockOffer.getStockSymbol() + " added to inventory");
            buyOffers.add(stockOffer);
        }
    }

    public void getStockOfferings() {
        if(saleOffers.size()>0) {
            System.out.println("\nStocks in Sale");
            for (StockOffer offer : saleOffers) {
                System.out.println(offer.getStockShares() + " of " + offer.getStockSymbol());
            }
        }

        if(buyOffers.size()>0){
            System.out.println("\nStocks to Buy");
            for (StockOffer offer: buyOffers){
                System.out.println(offer.getStockShares() + " of " + offer.getStockSymbol());
            }
        }

    }
}
