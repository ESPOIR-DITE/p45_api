package org.example.factory.candidate;

import org.example.domain.user.Party;
import org.example.util.GenerateId;

public class PartyFactory {
    public static Party getParty(String name,String description,byte[] flag){
        return new Party.Builder(GenerateId.getId(PartyFactory.class))
                .buildDescription(description)
                .buildFlag(flag)
                .buildName(name)
                .build();
    }
}
