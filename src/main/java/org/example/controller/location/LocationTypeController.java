package org.example.controller.location;

import org.example.controller.Icontroller;
import org.example.domain.location.LocationType;
import org.example.service.location.LocationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/location_type")
public class LocationTypeController implements Icontroller<LocationType,String> {
    @Autowired
    private LocationTypeService locationTypeService;

    @PostMapping("create")
    @Override
    public LocationType create(@RequestBody LocationType locationType) {
        return locationTypeService.create(locationType);
    }

    @PostMapping("update")
    @Override
    public LocationType update(@RequestBody LocationType locationType) {
        return locationTypeService.update(locationType);
    }

    @GetMapping("read")
    @Override
    public LocationType read(@RequestParam("id") String id) {
        return locationTypeService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return locationTypeService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<LocationType> readAll() {
        return locationTypeService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return locationTypeService.count();
    }
}
