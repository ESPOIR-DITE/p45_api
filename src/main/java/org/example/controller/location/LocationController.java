package org.example.controller.location;

import org.example.controller.Icontroller;
import org.example.domain.location.Location;
import org.example.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/location")
public class LocationController implements Icontroller<Location,String> {
    @Autowired
    private LocationService locationService;

    @PostMapping("create")
    @Override
    public Location create(@RequestBody Location location) {
        return locationService.create(location);
    }

    @PostMapping("update")
    @Override
    public Location update(@RequestBody Location location) {
        return locationService.update(location);
    }

    @GetMapping("read")
    @Override
    public Location read(@RequestParam("id") String id) {
        return locationService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return locationService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Location> readAll() {
        return locationService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return locationService.count();
    }
}
