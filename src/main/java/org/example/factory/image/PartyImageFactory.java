package org.example.factory.image;

import org.example.domain.image.PartyImage;
import org.example.util.GenerateId;

public class PartyImageFactory {
    public static PartyImage getPartyImage(String partyId,String imageId){
        return new PartyImage.Builder(GenerateId.getId(PartyImageFactory.class))
                .buildImageId(imageId)
                .buildPartyId(partyId)
                .build();
    }
}
