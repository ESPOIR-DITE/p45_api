package org.example.controller.vote;

import org.apache.commons.io.FileUtils;
import org.example.controller.Icontroller;
import org.example.domain.vote.Vote;
import org.example.domain.vote.VoteHelper;
import org.example.domain.vote.VoteResult;
import org.example.factory.vote.VoteFactory;
import org.example.service.vote.VoteService;
import org.example.service.vote.VoterService;
import org.example.util.ImageResizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("p45_api/vote/")
public class VoteController implements Icontroller<Vote,String> {
    @Autowired
    private VoteService voteService;

    @Autowired
    private VoterService voterService;


    @PostMapping("create")
    public Vote create(@RequestBody Vote vote) throws IOException {

        Boolean result = voterService.asVoted(vote.getVoterId());

        Vote vote1 = VoteFactory.getVote(vote.getCandidateId(),vote.getDate(),vote.getLocationId(), vote.getVoterId());
        return voteService.create(vote1);
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

    @GetMapping("result")
    public List<VoteResult> getResult(){
        //System.out.println(" we are in");
        return voteService.voteResult();
    }
}
