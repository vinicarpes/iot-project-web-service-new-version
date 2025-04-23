package br.ifsc.edu.fln.iotprojectapi.services;

import br.ifsc.edu.fln.iotprojectapi.models.Location;
import br.ifsc.edu.fln.iotprojectapi.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public boolean existsByLatitude(float latitude) {
        return locationRepository.existsByLatitude(latitude);
    }


    public boolean existsByLongitude(float longitude) {
        return locationRepository.existsByLongitude(longitude);
    }


    public Location save(Location location) {
        return locationRepository.save(location);
    }


    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return locationRepository.existsById(id);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    public void delete(Location location) {
        locationRepository.delete(location);
    }

}
