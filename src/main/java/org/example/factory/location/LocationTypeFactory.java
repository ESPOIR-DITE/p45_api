package org.example.factory.location;

import org.example.domain.location.LocationType;
import org.example.util.GenerateId;

public class LocationTypeFactory {
    public static LocationType getLocationType(String name,String description){
        return new LocationType.Builder(GenerateId.getId(LocationType.class))
                .buildDescription(description).buildName(name)
                .build();

    }
}
