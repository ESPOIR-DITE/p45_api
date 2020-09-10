package org.example.controller.image;

import org.example.controller.Icontroller;
import org.example.domain.image.PartyImage;
import org.example.service.image.PartyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/party_image")
public class PartyImageController implements Icontroller<PartyImage,String> {
    @Autowired
    private PartyImageService partyImageService;

    @PostMapping("create")
    @Override
    public PartyImage create(@RequestBody PartyImage partyImage) {
        return partyImageService.create(partyImage);
    }

    @PostMapping("update")
    @Override
    public PartyImage update(@RequestBody PartyImage partyImage) {
        return partyImageService.update(partyImage);
    }

    @GetMapping("read")
    @Override
    public PartyImage read(@RequestParam("id") String id) {
        return partyImageService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return partyImageService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<PartyImage> readAll() {
        return partyImageService.readAll();
    }

    @Override
    public Long count() {
        return null;
    }
}
