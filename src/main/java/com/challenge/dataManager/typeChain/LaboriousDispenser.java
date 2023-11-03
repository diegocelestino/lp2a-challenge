package com.challenge.dataManager.typeChain;

import com.challenge.models.Coordinate;
import com.challenge.models.Type;

public class LaboriousDispenser implements TypeChain {
    private TypeChain chain;
    private final Type type = Type.LABORIOUS;

    @Override
    public void setNextChain(TypeChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public Type dispense(Coordinate coordinate) {
        return this.type;
    }

    @Override
    public boolean coordinatesMatch(Coordinate coordinate) {
        return false;
    }
}
