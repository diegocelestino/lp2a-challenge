package com.challenge.dataManager.typeChain;

import com.challenge.models.BoundingBox;
import com.challenge.models.Coordinate;
import com.challenge.models.Type;

import java.util.List;


public class SpecialDispenser implements TypeChain {
    private TypeChain chain;
    private final Type type = Type.SPECIAL;


    @Override
    public void setNextChain(TypeChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public Type dispense(Coordinate coordinate) {
        if(this.coordinatesMatch(coordinate)){
            return this.type;
        }
        return this.chain.dispense(coordinate);
    }

    @Override
    public boolean coordinatesMatch(Coordinate coordinate) {
        List<BoundingBox> boundingBoxes = SpecialBoundingBoxes.get();
        for (BoundingBox boundingBox: boundingBoxes) {
            if(boundingBox.coordinatesMatch(coordinate)){
                return true;
            }
        }
        return false;
    }

}
