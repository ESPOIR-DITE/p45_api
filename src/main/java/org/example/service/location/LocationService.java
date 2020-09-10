package org.example.service.location;

import org.example.domain.location.Location;
import org.example.repository.location.LocationRepository;
import org.example.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements Iservice<Location,String> {
    @Autowired
    private LocationRepository locationRepository;
    private static LocationService locationService;

    public static LocationService getLocationService() {
        if (locationService == null) {
            locationService = new LocationService();
        }
        return locationService;
    }

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location update(Location location) {
        if(delete(location.getId())){
            return create(location);
        }
        return null;
    }

    @Override
    public Location read(String id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        return locationOptional.orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Location location = read(id);
        if (location != null) {
            locationRepository.delete(location);
            return true;
        }
        return false;
    }

    @Override
    public List<Location> readAll() {
        return locationRepository.findAll();
    }

    public long count(){
        return locationRepository.count();
    }
}
