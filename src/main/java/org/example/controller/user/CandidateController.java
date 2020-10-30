package org.example.controller.user;

import org.example.controller.Icontroller;
import org.example.domain.user.Candidate;
import org.example.factory.candidate.CandidateFactory;
import org.example.service.user.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/candidate/")
public class CandidateController implements Icontroller<Candidate,String> {
    @Autowired
    private CandidateService candidateService;

    @PostMapping("create")
    @Override
    public Candidate create(@RequestBody Candidate candidate) {
        Candidate candidate1 = CandidateFactory.getCandidate(candidate.getName(),candidate.getSurname(),candidate.getPartyId());
        return candidateService.create(candidate1);
    }

    @PostMapping("update")
    @Override
    public Candidate update(@RequestBody Candidate candidate) {
        return candidateService.update(candidate);
    }

    @GetMapping("read")
    @Override
    public Candidate read(@RequestParam("id") String id) {
        return candidateService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return candidateService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Candidate> readAll() {
        return candidateService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return candidateService.count();
    }
}
