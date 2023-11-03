package com.challenge.dataManager.typeChain;

import com.challenge.models.Coordinate;
import com.challenge.models.Type;

public interface TypeChain {
    void setNextChain(TypeChain nextChain);
    Type dispense(Coordinate coordinate);
    boolean coordinatesMatch(Coordinate coordinate);
}
