package org.example.service.vote;

import org.example.domain.user.Party;
import org.example.domain.vote.Vote;
import org.example.domain.vote.VoteResult;
import org.example.repository.vote.VoteRepository;
import org.example.repository.vote.VoterRepository;
import org.example.service.Iservice;
import org.example.service.user.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService implements Iservice<Vote,String> {
    @Autowired
    private VoteRepository voterRepository;
    @Autowired
    private PartyService partyService;

    private static VoteService voteService;

    public static VoteService getVoteService() {
        if (voteService == null) {
            voteService = new VoteService();
        }
        return voteService;
    }

    @Override
    public Vote create(Vote vote) {
        return voterRepository.save(vote);
    }

    @Override
    public Vote update(Vote vote) {
        return voterRepository.save(vote);
    }

    @Override
    public Vote read(String id) {
        Optional<Vote> voteOptional = voterRepository.findById(id);
        return voteOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Vote vote = read(id);
        if (vote != null) {
            voterRepository.delete(vote);
            return true;
        }
        return false;
    }

    @Override
    public List<Vote> readAll() {
        return voterRepository.findAll();
    }
    public Long count(){
        return voterRepository.count();
    }

    public List<VoteResult> voteResult(){
        List<VoteResult> results = new ArrayList<>();
        for(Party party: partyService.readAll()){
            voterRepository.countByCandidateId(party.getId());
            results.add(new VoteResult(party.getName(),voterRepository.countByCandidateId(party.getId())));
        }
        return results;
    }
}
