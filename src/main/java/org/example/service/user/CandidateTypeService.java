package org.example.service.user;

import org.example.domain.user.Candidate;
import org.example.domain.user.CandidateType;
import org.example.repository.cadidate.CandidateRepo;
import org.example.repository.cadidate.CandidateTypeRep;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateTypeService implements Iservice<CandidateType,String> {
    @Autowired
    private CandidateTypeRep candidateRepo;
    private static CandidateService candidateService;

    public static CandidateService getCandidateService() {
        if (candidateService == null) {
            candidateService = new CandidateService();
        }
        return candidateService;
    }

    @Override
    public CandidateType create(CandidateType candidateType) {
        return candidateRepo.save(candidateType);
    }

    @Override
    public CandidateType update(CandidateType candidateType) {
        return candidateRepo.save(candidateType);
    }

    @Override
    public CandidateType read(String id) {
        Optional<CandidateType> candidateOptional = candidateRepo.findById(id);
        return candidateOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        CandidateType candidateType = read(id);
        if (candidateType != null) {
            candidateRepo.delete(candidateType);
            return true;
        }
        return false;
    }

    @Override
    public List<CandidateType> readAll() {
        return candidateRepo.findAll();
    }
    public Long count(){
        return candidateRepo.count();
    }
}
