package com.challenge.dataManager;

import com.challenge.dataManager.regionChain.DispenseChain;
import com.challenge.models.*;
import com.challenge.models.json.JsonClient;

import java.sql.Timestamp;
import java.util.List;



public class JsonClientBuilder {

    public static Client build(JsonClient jsonClient){
        return new Client(
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
        DispenseChain dispenseChain = new DispenseChain();
        return new Location(
                dispenseChain.first.dispense(jsonClient.getLocation().getState()),
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
