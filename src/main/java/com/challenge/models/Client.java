package com.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Type type;
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Timestamp birthday;
    private Timestamp registered;
    private List<String> telephoneNumbers;
    private Picture picture;
    private String nationality;
}
