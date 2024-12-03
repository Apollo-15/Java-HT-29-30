package com.hometask2930;

import java.util.ArrayList;
import java.util.List;

public class StockMarketImpl implements StockMarket {
    private List<StockObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(RequestBody requestBody) {
        for (StockObserver observer : observers) {
            observer.update(requestBody);
        }
    }

    public void setStockPrice(RequestBody requestBody) {
        notifyObservers(requestBody);
    }
}