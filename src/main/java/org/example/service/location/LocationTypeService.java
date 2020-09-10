package org.example.service.location;

import org.example.domain.location.LocationType;
import org.example.repository.location.LocationTypeRepo;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationTypeService implements Iservice<LocationType,String> {
    @Autowired
    private LocationTypeRepo locationTypeRepo;
    private static LocationTypeService locationTypeService;

    public static LocationTypeService getLocationTypeService() {
        if (locationTypeService == null) {
            locationTypeService = new LocationTypeService();
        }
        return locationTypeService;
    }

    @Override
    public LocationType create(LocationType locationType) {
        return locationTypeRepo.save(locationType);
    }

    @Override
    public LocationType update(LocationType locationType) {
        if(delete(locationType.getId())){
            locationTypeRepo.save(locationType);
            return locationType;
        }
        return null;
    }

    @Override
    public LocationType read(String id) {
        Optional<LocationType> locationTypeOptional = locationTypeRepo.findById(id);
        return locationTypeOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        LocationType locationType = read(id);
        if(locationType!=null){
            locationTypeRepo.delete(locationType);
            return true;
        }
        return false;
    }

    @Override
    public List<LocationType> readAll() {
        return locationTypeRepo.findAll();
    }
    public long count(){
        return locationTypeRepo.count();
    }
}
