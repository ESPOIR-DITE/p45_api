package org.example.controller.vote;

import org.example.controller.Icontroller;
import org.example.domain.vote.Vote;
import org.example.service.vote.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/vote")
public class VoteController implements Icontroller<Vote,String> {
    @Autowired
    private VoteService voteService;

    @PostMapping("create")
    @Override
    public Vote create(@RequestBody Vote vote) {
        return voteService.create(vote);
    }

    @PostMapping("update")
    @Override
    public Vote update(@RequestBody Vote vote) {
        return voteService.update(vote);
    }

    @GetMapping("read")
    @Override
    public Vote read(@RequestParam("id") String id) {
        return voteService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return voteService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Vote> readAll() {
        return voteService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return voteService.count();
    }
}
