package org.example.factory.vote;

import org.example.domain.vote.Vote;
import org.example.util.GenerateId;

public class VoteFactory {
    public static Vote getVote(String candidateId, String date, String locationId){
        return new Vote.Builder(GenerateId.getId(VoteFactory.class))
                .buildCandidateId(candidateId)
                .buildLocation(locationId)
                .Date(date)
                .build();
    }
}
