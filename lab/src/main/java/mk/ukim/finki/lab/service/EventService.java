package mk.ukim.finki.lab.service;

import java.util.List;
import java.util.Optional;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;

public interface EventService {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    Event createEvent(String name, String description, Double popularityScore, Location location, Long numCards);

    // Event updateEvent(Long id, String name, String description, Double
    // popularityScore, Location location,
    // Long numCards);

    boolean removeEvent(Long id);

    // List<Event> searchEvents(String text);
}
