package org.example.controller.vote;

import org.example.controller.Icontroller;
import org.example.domain.vote.Voter;
import org.example.service.vote.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/voter")
public class VoterController implements Icontroller<Voter,String> {
    @Autowired
    private VoterService voterService;

    @PostMapping("create")
    @Override
    public Voter create(@RequestBody Voter voter) {
        return voterService.create(voter);
    }

    @PostMapping("update")
    @Override
    public Voter update(@RequestBody Voter voter) {
        return voterService.update(voter);
    }

    @GetMapping("read")
    @Override
    public Voter read(@RequestParam("id") String id) {
        return voterService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return voterService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Voter> readAll() {
        return voterService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return voterService.count();
    }
}
