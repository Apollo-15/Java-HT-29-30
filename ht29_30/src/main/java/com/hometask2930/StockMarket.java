package com.hometask2930;

public interface StockMarket {
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(RequestBody requestBody);
}