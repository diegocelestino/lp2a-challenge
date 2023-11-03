package com.challenge.dataManager.typeChain;

public class DispenseTypeChain {
    public TypeChain first;

    public DispenseTypeChain(){
        this.first = new SpecialDispenser();
        TypeChain second = new NormalDispenser();
        TypeChain third = new LaboriousDispenser();

        first.setNextChain(second);
        second.setNextChain(third);
    }
}
