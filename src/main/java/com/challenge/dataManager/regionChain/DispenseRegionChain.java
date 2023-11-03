package com.challenge.dataManager.regionChain;

public class DispenseRegionChain {
    public RegionChain first;

    public DispenseRegionChain(){
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
