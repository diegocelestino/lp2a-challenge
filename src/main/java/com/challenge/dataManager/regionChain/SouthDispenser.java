package com.challenge.dataManager.regionChain;

import java.util.List;

public class SouthDispenser implements RegionChain {
    private RegionChain chain;
    private final String region = "sul";
    private final List<String> states = List.of("paraná", "rio grande do sul", "santa catarina");

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
