package mk.ukim.finki.lab.service;

import java.util.List;
import java.util.Optional;

import mk.ukim.finki.lab.model.Location;

public interface LocationService {

    public List<Location> findAll();

    public Optional<Location> findById(Long id);
}