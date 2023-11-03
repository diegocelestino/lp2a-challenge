package com.challenge;

import com.challenge.dtos.ClientDto;
import com.challenge.models.Address;
import com.challenge.models.Client;
import com.challenge.models.Location;
import com.challenge.models.Name;

import org.springframework.stereotype.Component;



@Component
public class ClientMapper {

    public ClientDto to(Client client){
        return new ClientDto(
                client.getId(),
                client.getType(),
                client.getGender(),
                mapName(client.getName()),
                mapAddress(client.getLocation()),
                client.getEmail(),
                client.getBirthday(),
                client.getRegistered(),
                client.getTelephoneNumbers(),
                client.getPicture(),
                client.getNationality()
        );
    }

    private Address mapAddress(Location location) {
        return new Address(
                location.getRegion(),
                mapStreet(location.getStreet()),
                location.getCity(),
                location.getState(),
                location.getPostCode()
        );
    }

    private String mapStreet(String street) {
        return (street.substring(street.indexOf(" ")).replaceFirst(" ", "") +
                " " + street.substring(0, street.indexOf(" "))).replace("  ", " ");
    }

    private String mapName(Name clientName){
        return clientName.getFirst() + " " + clientName.getLast();
    }
}
