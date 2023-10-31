package com.challenge.dataManager;

import com.challenge.dataManager.regionChain.DispenseChain;
import com.challenge.models.*;

import java.sql.Timestamp;
import java.util.List;

public class CsvClientBuilder {

    public static Client build(String[] array){
        Name name = buildName(array);
        Location location = buildLocation(array);
        Picture picture = new Picture(array[19], array[20], array[21]);
        List<String> telephones = List.of(array[17], array[18]);
        return new Client(
                Type.NORMAL,
                array[0].replace(";", ""),
                name,
                location,
                array[12],
                Timestamp.valueOf(array[13].replace("T", " ").replace("Z", "")),
                Timestamp.valueOf(array[15].replace("T", " ").replace("Z", "")),
                telephones,
                picture,
                "BR"
        );
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

    private static Location buildLocation(String[] array){
        DispenseChain dispenseChain = new DispenseChain();
        return new Location(
                dispenseChain.first.dispense(array[6]),
                array[4],
                array[5],
                array[6],
                array[7],
                buildCoordinate(array),
                buildTimezone(array));
    }

}
