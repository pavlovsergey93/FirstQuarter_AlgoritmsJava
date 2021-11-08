package com.geekbrains.algorithms.lesson5.Backpack;

public class Baggage {
    private String name;
    private int wt;
    private int worth;
    public Baggage(String name, int wt, int worth){
        this.name = name;
        this.wt = wt;
        this.worth = worth;
    }

    public String getName() {
        return name;
    }

    public int getWt() {
        return wt;
    }

    public int getWorth() {
        return worth;
    }
    public int worthOneKgBaggage(){
        return (this.worth/this.wt);
    }
}
