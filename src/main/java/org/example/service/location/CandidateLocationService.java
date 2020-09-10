package org.example.service.location;

import org.example.domain.location.CandidateLocation;
import org.example.repository.location.CandidateLocationRepo;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateLocationService implements Iservice<CandidateLocation,String> {
    @Autowired
    private CandidateLocationRepo candidateLocationRepo;
    private static CandidateLocationService candidateLocationService;

    public static CandidateLocationService getCandidateLocationService() {
        if (candidateLocationService == null) {
            candidateLocationService = new CandidateLocationService();
        }
        return candidateLocationService;
    }

    @Override
    public CandidateLocation create(CandidateLocation candidateLocation) {
        return candidateLocationRepo.save(candidateLocation);
    }

    @Override
    public CandidateLocation update(CandidateLocation candidateLocation) {
        if(delete(candidateLocation.getId())){
            candidateLocationRepo.save(candidateLocation);
            return candidateLocation;
        }
        return null;
    }

    @Override
    public CandidateLocation read(String id) {
        Optional<CandidateLocation> candidateLocationOptional = candidateLocationRepo.findById(id);
        return candidateLocationOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        CandidateLocation candidateLocation = read(id);
        if (candidateLocation != null) {
            candidateLocationRepo.delete(candidateLocation);
            return true;
        }
        return false;
    }

    @Override
    public List<CandidateLocation> readAll() {
        return candidateLocationRepo.findAll();
    }

}
