package com.challenge.dataManager.regionChain;

import java.util.List;

public class NortheastDispenser implements RegionChain {
    private RegionChain chain;
    private final String region = "nordeste";
    private final List<String> states = List.of("maranhão", "piauí", "ceará", "rio grande do norte", "pernambuco",
            "paraíba", "sergipe", "alagoas", "bahia");

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
