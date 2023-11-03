package com.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoundingBox {
    private Double minLat;
    private Double maxLat;
    private Double minLon;
    private Double maxLon;

    public boolean coordinatesMatch(Coordinate coordinate){
        return this.latitudeMatch(coordinate.getLatitude()) && this.longitudeMatch(coordinate.getLongitude());
    }

    public boolean latitudeMatch(Double latitude){
        return minLat <= latitude && latitude <= maxLat;
    }

    public boolean longitudeMatch(Double longitude){
        return minLon >= longitude && longitude >= maxLon;
    }
}
