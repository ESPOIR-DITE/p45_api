package org.example.service.user;

import org.example.domain.user.Party;
import org.example.repository.cadidate.PartyRepo;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyService implements Iservice<Party,String> {
    @Autowired
    private PartyRepo partyRepo;

    private static PartyService partyService;

    public static PartyService getPartyService() {
        if (partyService == null) {
            partyService = new PartyService();
        }
        return partyService;
    }

    @Override
    public Party create(Party party) {
        return partyRepo.save(party);
    }

    @Override
    public Party update(Party party) {
        return partyRepo.save(party);
    }

    @Override
    public Party read(String id) {
        Optional<Party>partyOptional = partyRepo.findById(id);
        return partyOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Party party = read(id);
        if (party != null) {
            partyRepo.delete(party);
            return true;
        }
        return false;
    }

    @Override
    public List<Party> readAll() {
        return partyRepo.findAll();
    }

    public Long count(){
        return partyRepo.count();
    }
}
