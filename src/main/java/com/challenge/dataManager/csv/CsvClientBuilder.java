package com.challenge.dataManager.csv;

import com.challenge.dataManager.regionChain.DispenseRegionChain;
import com.challenge.models.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class CsvClientBuilder {

    public static Client build(String[] array){
        return new Client(
                UUID.randomUUID(),
                Type.NORMAL,
                buildGender(array),
                buildName(array),
                buildLocation(array),
                buildEmail(array),
                buildBirthdate(array),
                buildRegisteredDate(array),
                buildTelephones(array),
                buildPicture(array),
                "BR"
        );
    }

    private static String buildGender(String[] array){
        if (array[0].equals(";male")){
            return "m";
        } else {
            return "f";
        }
    }

    private static String buildEmail(String[] array){
        return array[12];
    }

    private static Timestamp buildBirthdate(String[] array){
        return Timestamp.valueOf(array[13].replace("T", " ").replace("Z", ""));
    }

    private static Timestamp buildRegisteredDate(String[] array){
        return Timestamp.valueOf(array[15].replace("T", " ").replace("Z", ""));
    }

    private static Name buildName(String[] array){
        return new Name(array[1], array[2], array[3]);
    }

    private static Coordinate buildCoordinate(String[] array){
        return new Coordinate(Double.valueOf(array[8]), Double.valueOf(array[9]));
    }

    private static Timezone buildTimezone(String[] array){
        return new Timezone(array[10], array[11]);
    }

    private static Picture buildPicture(String[] array){
        return new Picture(array[19], array[20], array[21]);
    }

    private static List<String> buildTelephones(String[] array){
        return List.of(convertTelephone(array[17]), convertTelephone(array[18]));
    }

    public static String convertTelephone(String number){
        return "+55" + number
                .replace("(","")
                .replace(")", "")
                .replace("-", "")
                .replace(" ", "");
    }

    private static Location buildLocation(String[] array){
        DispenseRegionChain dispenseRegionChain = new DispenseRegionChain();
        return new Location(
                dispenseRegionChain.first.dispense(array[6]),
                array[4],
                array[5],
                array[6],
                array[7],
                buildCoordinate(array),
                buildTimezone(array));
    }

}
