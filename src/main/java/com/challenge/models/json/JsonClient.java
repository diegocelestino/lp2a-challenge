package com.challenge.models.json;

import com.challenge.models.Name;
import com.challenge.models.Picture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonClient {
    private String gender;
    private Name name;
    private JsonLocation location;
    private String email;
    private Dob dob;
    private Dob registered;
    private String phone;
    private String cell;
    private Picture picture;
}
