package org.example.service.image;

import org.example.domain.image.Images;
import org.example.repository.image.ImagesRepository;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements Iservice<Images,String> {
    @Autowired
    private ImagesRepository imagesRepository;
    private static ImageService imageService;

    public static ImageService getImageService() {
        if (imageService == null) {
            imageService = new ImageService();
        }
        return imageService;
    }

    @Override
    public Images create(Images images) {
        return imagesRepository.save(images);
    }

    @Override
    public Images update(Images images) {
        return imagesRepository.save(images);
    }

    @Override
    public Images read(String id) {
        return getImage(id);
    }

    @Override
    public Boolean delete(String id) {
        Images images = getImage(id);
        if (images != null) {
            imagesRepository.delete(images);
            return true;
        }
        return false;
    }

    @Override
    public List<Images> readAll() {
        return imagesRepository.findAll();
    }

    public Images getImage(String id){
        Optional<Images> imagesOptional = imagesRepository.findById(id);
        return imagesOptional.orElse(null);
    }
}
