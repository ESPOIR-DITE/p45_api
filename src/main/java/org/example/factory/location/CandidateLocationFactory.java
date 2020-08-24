package org.example.factory.location;

import org.example.domain.location.CandidateLocation;
import org.example.domain.user.Candidate;
import org.example.util.GenerateId;

public class CandidateLocationFactory {
    public static CandidateLocation getCandidateLocation(String candidateId,String locationId){
        return new CandidateLocation.Builder(GenerateId.getId(CandidateLocationFactory.class))
                .buildCandidateId(candidateId).buildLocationId(locationId)
                .build();
    }
}
