package org.example.factory.vote;

import org.example.domain.vote.Voter;

public class VoterFactory {
    public static Voter getVoter(String id,String name,String surname,String phoneNumber/**,byte[] fingerPrint*/,byte[] image,Boolean canVote){
        return new Voter.Builder(id)
               // .buildFingerPrint(fingerPrint)
                .buildName(name)
                .buildImage(image)
                .buildPhoneNumber(phoneNumber)
                .buildSurname(surname)
                .buildCanVote(canVote)
                .build();
    }
    public static Voter getVoterHasVoted(Voter voter){
        return new Voter.Builder(voter.getId())
                // .buildFingerPrint(fingerPrint)
                .buildName(voter.getName())
                .buildImage(voter.getImage())
                .buildPhoneNumber(voter.getPhoneNumber())
                .buildSurname(voter.getSurname())
                .buildCanVote(false)
                .build();
    }
}
