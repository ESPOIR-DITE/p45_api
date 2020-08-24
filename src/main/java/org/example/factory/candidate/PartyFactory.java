package org.example.factory.candidate;

import org.example.domain.user.Party;
import org.example.util.GenerateId;

public class PartyFactory {
    public static Party getParty(String name,String description){
        return new Party.Builder(GenerateId.getId(PartyFactory.class))
                .buildDescription(description)
                .buildName(name)
                .build();
    }
}
