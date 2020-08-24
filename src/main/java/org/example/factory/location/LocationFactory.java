package org.example.factory.location;

import org.example.domain.location.Location;
import org.example.util.GenerateId;

public class LocationFactory {
    public static Location getLocation(String location,String address,String description,String parentLocationId){
        return new Location.Builder(GenerateId.getId(LocationFactory.class))
                .buildAddress(address).buildDescription(description).buildLocation(location)
                .buildParentLocationId(parentLocationId)
                .build();
    }
}
