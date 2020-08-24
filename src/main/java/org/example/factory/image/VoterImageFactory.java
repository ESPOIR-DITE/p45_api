package org.example.factory.image;

import org.example.domain.image.VoterImage;
import org.example.util.GenerateId;

public class VoterImageFactory {
    public static VoterImage getVoterImage(String imageId,String voterId){
        return new VoterImage.Builder(GenerateId.getId(VoterImageFactory.class))
                .buildImageId(imageId).buildVoterId(voterId).build();
    }
}
