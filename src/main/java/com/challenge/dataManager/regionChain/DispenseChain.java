package com.challenge.dataManager.regionChain;

public class DispenseChain {
    public RegionChain first;

    public DispenseChain(){
        this.first = new SouthDispenser();
        RegionChain second = new SoutheastDispenser();
        RegionChain third = new WestCenterDispenser();
        RegionChain fourth = new NortheastDispenser();
        RegionChain fifth = new NorthDispenser();

        first.setNextChain(second);
        second.setNextChain(third);
        third.setNextChain(fourth);
        fourth.setNextChain(fifth);

    }
}
