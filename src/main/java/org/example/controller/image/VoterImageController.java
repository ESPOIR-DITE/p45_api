package org.example.controller.image;

import org.example.controller.Icontroller;
import org.example.domain.image.VoterImage;
import org.example.service.image.VoterImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/voter_image")
public class VoterImageController implements Icontroller<VoterImage,String> {
    @Autowired
    private VoterImageService voterImageService;

    @PostMapping("create")
    @Override
    public VoterImage create(@RequestBody VoterImage voterImage) {
        return voterImageService.create(voterImage);
    }

    @PostMapping("update")
    @Override
    public VoterImage update(@RequestBody VoterImage voterImage) {
        return voterImageService.update(voterImage);
    }

    @GetMapping("read")
    @Override
    public VoterImage read(@RequestParam("id") String id) {
        return voterImageService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return voterImageService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<VoterImage> readAll() {
        return voterImageService.readAll();
    }

    @Override
    public Long count() {
        return null;
    }
}
