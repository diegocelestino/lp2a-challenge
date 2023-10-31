package com.challenge.dataManager.regionChain;

import java.util.List;

public class SoutheastDispenser implements RegionChain {
    private RegionChain chain;
    private final String region = "sudeste";
    private final List<String> states = List.of("são paulo", "rio de janeiro", "espírito santo", "minas gerais");


    @Override
    public void setNextChain(RegionChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String dispense(String state) {
        if (states.contains(state)){
            return this.region;
        } else {
            return this.chain.dispense(state);
        }
    }

}
