package com.challenge.dataManager.regionChain;

import java.util.List;

public class NorthDispenser implements RegionChain {
    private RegionChain chain;
    private final String region = "norte";
    private final List<String> states = List.of("amazonas", "roraima", "amapá", "pará", "tocantins",
            "rondônia", "acre");

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
