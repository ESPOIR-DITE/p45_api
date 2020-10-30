package org.example.controller.user;

import org.example.controller.Icontroller;
import org.example.domain.user.Party;
import org.example.factory.candidate.PartyFactory;
import org.example.service.user.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/party/")
public class PartyController implements Icontroller<Party,String> {
    @Autowired
    private PartyService partyService;

    @PostMapping("create")
    @Override
    public Party create(@RequestBody Party party) {
        Party party1 = PartyFactory.getParty(party.getName(),party.getDescription(),party.getFlag());
        return partyService.create(party1);
    }

    @PostMapping("update")
    @Override
    public Party update(@RequestBody Party party) {
        return partyService.update(party);
    }

    @GetMapping("read")
    @Override
    public Party read(@RequestParam("id") String id) {
        return partyService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return partyService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Party> readAll() {
        return partyService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return partyService.count();
    }
}
