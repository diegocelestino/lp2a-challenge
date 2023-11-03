package com.challenge.dtos;

import com.challenge.models.Location;
import com.challenge.models.Name;
import com.challenge.models.Picture;
import com.challenge.models.Type;
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
    private Location location;
    private String email;
    private Timestamp birthday;
    private Timestamp registered;
    private List<String> telephoneNumbers;
    private Picture picture;
    private String nationality;
}
