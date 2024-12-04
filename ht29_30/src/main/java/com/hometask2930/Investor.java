package com.hometask2930;

public class Investor implements StockObserver {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(RequestBody requestBody) {
        System.out.println("Я " + name + " отримав "+ requestBody + "\n");
    }
}