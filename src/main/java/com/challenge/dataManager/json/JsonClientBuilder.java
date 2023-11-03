package com.challenge.dataManager.json;

import com.challenge.dataManager.csv.CsvClientBuilder;
import com.challenge.dataManager.regionChain.DispenseRegionChain;
import com.challenge.models.*;
import com.challenge.models.json.JsonClient;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


public class JsonClientBuilder {

    public static Client build(JsonClient jsonClient){
        return new Client(
                UUID.randomUUID(),
                Type.NORMAL,
                buildGender(jsonClient),
                jsonClient.getName(),
                buildLocation(jsonClient),
                jsonClient.getEmail(),
                buildBirthdate(jsonClient),
                buildRegisteredDate(jsonClient),
                buildTelephones(jsonClient),
                jsonClient.getPicture(),
                "BR"
        );
    }

    private static String buildGender(JsonClient jsonClient){
        if(jsonClient.getGender().equals("male")){
            return "m";
        }else {
            return "f";
        }
    }

    private static Timestamp buildBirthdate(JsonClient jsonClient){
        return Timestamp.valueOf(jsonClient.getDob().getDate().replace("T", " ").replace("Z", ""));
    }

    private static Location buildLocation(JsonClient jsonClient){
        DispenseRegionChain dispenseRegionChain = new DispenseRegionChain();
        return new Location(
                dispenseRegionChain.first.dispense(jsonClient.getLocation().getState()),
                jsonClient.getLocation().getStreet(),
                jsonClient.getLocation().getCity(),
                jsonClient.getLocation().getState(),
                jsonClient.getLocation().getPostcode(),
                jsonClient.getLocation().getCoordinates(),
                jsonClient.getLocation().getTimezone()
                );
    }

    private static Timestamp buildRegisteredDate(JsonClient jsonClient){
        return Timestamp.valueOf(jsonClient.getRegistered().getDate().replace("T", " ").replace("Z", ""));
    }

    private static List<String> buildTelephones(JsonClient jsonClient){
        return List.of(CsvClientBuilder.convertTelephone(jsonClient.getCell()),
                CsvClientBuilder.convertTelephone(jsonClient.getPhone()));
    }
}
