package com.challenge;

import com.challenge.dataManager.typeChain.DispenseTypeChain;
import com.challenge.models.Coordinate;

public class TestTypeChain {

    public static void main(String[] args) {

        Coordinate coordinate = new Coordinate(-50.12345, -30.411580);
        DispenseTypeChain dispenseTypeChain = new DispenseTypeChain();

        System.out.println(dispenseTypeChain.first.dispense(coordinate));
    }
}
