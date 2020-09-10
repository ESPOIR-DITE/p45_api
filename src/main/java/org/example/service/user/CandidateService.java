package org.example.service.user;

import org.example.domain.user.Candidate;
import org.example.repository.cadidate.CandidateRepo;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements Iservice<Candidate,String> {
    @Autowired
    private CandidateRepo candidateRepo;
    private static CandidateService candidateService;

    public static CandidateService getCandidateService() {
        if (candidateService == null) {
            candidateService = new CandidateService();
        }
        return candidateService;
    }

    @Override
    public Candidate create(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    @Override
    public Candidate update(Candidate candidate) {
        if(delete(candidate.getId())){
            return create(candidate);
        }
        return null;
    }

    @Override
    public Candidate read(String id) {
        Optional<Candidate> candidateOptional = candidateRepo.findById(id);
        return candidateOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Candidate candidate = read(id);
        if (candidate != null) {
            candidateRepo.delete(candidate);
            return true;
        }
        return false;
    }

    @Override
    public List<Candidate> readAll() {
        return candidateRepo.findAll();
    }
    public Long count(){
        return candidateRepo.count();
    }
}
