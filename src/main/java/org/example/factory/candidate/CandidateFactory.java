package org.example.factory.candidate;

import org.example.domain.user.Candidate;
import org.example.util.GenerateId;

public class CandidateFactory {
    public static Candidate getCandidate(String name,String surname,String partyId){
        return new Candidate.Builder(GenerateId.getId(CandidateFactory.class))
                .buildName(name).buildPartyId(partyId).buildSurname(surname).build();
    }
}
