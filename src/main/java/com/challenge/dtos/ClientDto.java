package com.challenge.dtos;

import com.challenge.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private UUID id;
    private Type type;
    private String gender;
    private String name;
    private Address address;
    private String email;
    private Timestamp birthday;
    private Timestamp registered;
    private List<String> telephoneNumbers;
    private Picture picture;
    private String nationality;
}
