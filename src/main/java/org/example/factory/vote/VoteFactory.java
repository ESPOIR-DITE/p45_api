package org.example.factory.vote;

import org.example.domain.vote.Vote;
import org.example.util.GenerateId;

public class VoteFactory {
    public static Vote getVote(String candidateId, String date, String locationId, String voterId){
        return new Vote.Builder(GenerateId.getId(VoteFactory.class))
                .buildCandidateId(candidateId)
                .buildLocation(locationId)
                .buildVoterId(voterId)
                .Date(date)
                .build();
    }
}
