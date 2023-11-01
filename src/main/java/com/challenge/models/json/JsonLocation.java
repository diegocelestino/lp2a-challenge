package com.challenge.models.json;

import com.challenge.models.Coordinate;
import com.challenge.models.Timezone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonLocation {
    private String street;
    private String city;
    private String state;
    private String postcode;
    private Coordinate coordinates;
    private Timezone timezone;
}
