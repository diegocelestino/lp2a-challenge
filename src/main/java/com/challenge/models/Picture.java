package com.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    private String large;
    private String medium;
    private String thumbnail;
}
