package com.challenge.dataManager.regionChain;

public interface RegionChain {
    void setNextChain(RegionChain nextChain);
    String dispense(String state);
}
