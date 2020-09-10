package org.example.controller.location;

import org.example.controller.Icontroller;
import org.example.domain.location.CandidateLocation;
import org.example.service.location.CandidateLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/location_candidate")
public class CandidateLocationController implements Icontroller<CandidateLocation,String> {
    @Autowired
    private CandidateLocationService candidateLocationService;

    @PostMapping("create")
    @Override
    public CandidateLocation create(@RequestBody CandidateLocation candidateLocation) {
        return candidateLocationService.create(candidateLocation);
    }

    @PostMapping("update")
    @Override
    public CandidateLocation update(@RequestBody CandidateLocation candidateLocation) {
        return candidateLocationService.update(candidateLocation);
    }

    @GetMapping("read")
    @Override
    public CandidateLocation read(@RequestParam("id") String id) {
        return candidateLocationService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return candidateLocationService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<CandidateLocation> readAll() {
        return candidateLocationService.readAll();
    }

    @Override
    public Long count() {
        return null;
    }
}
