package org.example.controller.image;

import org.example.controller.Icontroller;
import org.example.domain.image.Images;
import org.example.factory.image.ImageFactory;
import org.example.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("p45_api/image")
public class ImageController implements Icontroller<Images,String> {
    @Autowired
    private ImageService imageService;

    @PostMapping("create")
    @Override
    public Images create(@RequestBody Images images) {
        Images images1 = ImageFactory.getImage(images.getImages());
        return imageService.create(images1);
    }

    @PostMapping("update")
    @Override
    public Images update(@RequestBody Images images) {
        return imageService.update(images);
    }

    @GetMapping("read")
    @Override
    public Images read(@RequestParam("id") String id) {
        return imageService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return imageService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Images> readAll() {
        return imageService.readAll();
    }

    @Override
    public Long count() {
        return null;
    }
}
