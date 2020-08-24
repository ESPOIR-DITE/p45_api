package org.example.factory.location;

import org.example.domain.location.VoterLocation;
import org.example.util.GenerateId;

public class VoterLocationFactory {
    public static VoterLocation getVoterLocation(String voterId,String locationId){
        return new VoterLocation.Builder(GenerateId.getId(VoterLocation.class))
                .buildLocationId(locationId)
                .buildVoterId(voterId)
                .build();
    }
}
