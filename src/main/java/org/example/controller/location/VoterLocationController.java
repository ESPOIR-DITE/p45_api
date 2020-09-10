package org.example.controller.location;

import org.example.controller.Icontroller;
import org.example.domain.location.VoterLocation;
import org.example.service.location.VoterLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/location_voter")
public class VoterLocationController implements Icontroller<VoterLocation,String> {
    @Autowired
    private VoterLocationService voterLocationService;

    @PostMapping("create")
    @Override
    public VoterLocation create(@RequestBody VoterLocation voterLocation) {
        return voterLocationService.create(voterLocation);
    }

    @PostMapping("update")
    @Override
    public VoterLocation update(@RequestBody VoterLocation voterLocation) {
        return voterLocationService.update(voterLocation);
    }

    @GetMapping("read")
    @Override
    public VoterLocation read(@RequestParam("id") String id) {
        return voterLocationService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(String id) {
        return voterLocationService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<VoterLocation> readAll() {
        return voterLocationService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return null;
    }
}
