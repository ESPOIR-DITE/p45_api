package org.example.factory.image;

import org.example.domain.image.Images;
import org.example.util.GenerateId;

public class ImageFactory {
    public static Images getImage(byte[] images){
        return new Images.Builder(GenerateId.getId(ImageFactory.class))
                .buildImage(images)
                .build();
    }
}
