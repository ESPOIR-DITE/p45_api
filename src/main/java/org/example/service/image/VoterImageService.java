package org.example.service.image;

import org.example.domain.image.VoterImage;
import org.example.repository.image.VoterImageRepository;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterImageService implements Iservice<VoterImage,String> {
    @Autowired
    private VoterImageRepository voterImageRepository;
    private static VoterImageService voterImageService;

    public static VoterImageService getVoterImageService() {
        if (voterImageService == null) {
            voterImageService = new VoterImageService();
        }
        return voterImageService;
    }

    @Override
    public VoterImage create(VoterImage voterImage) {
        return voterImageRepository.save(voterImage);
    }

    @Override
    public VoterImage update(VoterImage voterImage) {
        return voterImageRepository.save(voterImage);
    }

    @Override
    public VoterImage read(String id) {
        return getVoterImage(id);
    }

    @Override
    public Boolean delete(String id) {
        VoterImage voterImage = getVoterImage(id);
        if (voterImage != null) {
            voterImageRepository.delete(voterImage);
            return true;
        }
        return false;
    }

    @Override
    public List<VoterImage> readAll() {
        return voterImageRepository.findAll();
    }
    public VoterImage getVoterImage(String id){
        Optional<VoterImage> voterImageOptional = voterImageRepository.findById(id);
        return voterImageOptional.orElse(null);
    }
}
