package org.example.service.vote;

import org.example.domain.vote.Vote;
import org.example.domain.vote.Voter;
import org.example.repository.vote.VoteRepository;
import org.example.repository.vote.VoterRepository;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VoterService implements Iservice<Voter,String> {
    @Autowired
    private VoterRepository voterRepository;
    private static VoterService voteService;

    public static VoterService getVoteService() {
        if (voteService == null) {
            voteService = new VoterService();
        }
        return voteService;
    }

    @Override
    public Voter create(Voter vote) {
        return voterRepository.save(vote);
    }

    @Override
    public Voter update(Voter vote) {
        return voterRepository.save(vote);
    }

    @Override
    public Voter read(String id) {
        Optional<Voter> voteOptional = voterRepository.findById(id);
        return voteOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Voter vote = read(id);
        if (vote != null) {
            voterRepository.delete(vote);
            return true;
        }
        return false;
    }

    @Override
    public List<Voter> readAll() {
        return voterRepository.findAll();
    }
    public Long count(){
        return voterRepository.count();
    }
}
