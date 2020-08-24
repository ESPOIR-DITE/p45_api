package org.example.factory.vote;

import org.example.domain.vote.Voter;
import org.example.util.GenerateId;

public class VoterFactory {
    public static Voter getVoter(String name,String surname,String phoneNumber,byte[] fingerPrint){
        return new Voter.Builder(GenerateId.getId(VoteFactory.class))
                .buildFingerPrint(fingerPrint)
                .buildName(name)
                .buildPhoneNumber(phoneNumber)
                .buildSurname(surname)
                .build();
    }
}
