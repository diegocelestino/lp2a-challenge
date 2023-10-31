package com.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String region;
    private String street;
    private String city;
    private String state;
    private String postCode;
    private Coordinate coordinate;
    private Timezone timezone;
}
