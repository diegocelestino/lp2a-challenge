package com.challenge.dataManager.typeChain;

import com.challenge.models.BoundingBox;

import java.util.List;

class SpecialBoundingBoxes {

    public static List<BoundingBox> get(){
        return List.of(
                new BoundingBox(-46.361899, -34.276938, -2.196998, -15.411580),
                new BoundingBox(-52.997614, -44.428305, -19.766959, -23.966413)
        );
    }
}
