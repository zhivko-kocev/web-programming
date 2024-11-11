package mk.ukim.finki.lab.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.repository.LocationRepository;
import mk.ukim.finki.lab.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locations;

    public LocationServiceImpl(LocationRepository locations) {
        this.locations = locations;
    }

    @Override
    public List<Location> findAll() {
        return this.locations.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return this.locations.findById(id);
    }

}
