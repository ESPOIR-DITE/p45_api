package org.example.factory.candidate;

import org.example.domain.user.CandidateType;
import org.example.factory.location.CandidateLocationFactory;
import org.example.util.GenerateId;

public class CandidateTypeFactory {
    public static CandidateType getCandidateType(String name,String description){
        return new CandidateType.Builder(GenerateId.getId(CandidateLocationFactory.class))
                .buildDescription(description)
                .buildName(name)
                .build();
    }
}
