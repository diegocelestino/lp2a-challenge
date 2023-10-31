package com.challenge.dataManager.regionChain;

import java.util.List;

public class WestCenterDispenser implements RegionChain {
    private RegionChain chain;
    private final String region = "centro oeste";
    private final List<String> states = List.of("mato grosso", "mato grosso do sul", "goiás", "distrito federal");

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
