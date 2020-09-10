package org.example.service.location;

import org.example.domain.location.VoterLocation;
import org.example.repository.location.VoterLocationRepo;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterLocationService implements Iservice<VoterLocation,String> {
    @Autowired
    private VoterLocationRepo voterRepository;

    private static VoterLocationService voterService;

    public static VoterLocationService getVoterService() {
        if (voterService == null) {
            voterService = new VoterLocationService();
        }
        return voterService;
    }

    @Override
    public VoterLocation create(VoterLocation voter) {
        return voterRepository.save(voter);
    }

    @Override
    public VoterLocation update(VoterLocation voter) {
        if(delete(voter.getId())){
            return create(voter);
        }
        return null;
    }

    @Override
    public VoterLocation read(String id) {
        Optional<VoterLocation> voterOptional =voterRepository.findById(id);
        return voterOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        VoterLocation voter = read(id);
        if (voter != null) {
            voterRepository.delete(voter);
            return true;
        }
        return false;
    }

    @Override
    public List<VoterLocation> readAll() {
        return voterRepository.findAll();
    }
}
