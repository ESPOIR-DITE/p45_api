package org.example.service.image;

import org.example.domain.image.PartyImage;
import org.example.repository.image.PartyImageRepository;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyImageService implements Iservice<PartyImage,String> {
    @Autowired
    private PartyImageRepository partyImageRepository;
    private static PartyImageService partyImageService;

    public static PartyImageService getPartyImageService() {
        if (partyImageService == null) {
            partyImageService = new PartyImageService();
        }
        return partyImageService;
    }

    @Override
    public PartyImage create(PartyImage partyImage) {
        return partyImageRepository.save(partyImage);
    }

    @Override
    public PartyImage update(PartyImage partyImage) {
        return partyImageRepository.save(partyImage);
    }

    @Override
    public PartyImage read(String id) {
        return getPartyImage(id);
    }

    @Override
    public Boolean delete(String id) {
        PartyImage partyImage = getPartyImage(id);
        if (partyImage != null) {
            partyImageRepository.delete(partyImage);
            return true;
        }
        return null;
    }

    @Override
    public List<PartyImage> readAll() {
        return partyImageRepository.findAll();
    }
    public PartyImage getPartyImage(String id){
        Optional<PartyImage> partyImageOptional = partyImageRepository.findById(id);
        return partyImageOptional.orElse(null);
    }
}
