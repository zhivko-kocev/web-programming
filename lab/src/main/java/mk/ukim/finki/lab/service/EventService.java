package mk.ukim.finki.lab.service;

import java.util.List;

import mk.ukim.finki.lab.model.Event;

public interface EventService {
    List<Event> listAll();

    List<Event> searchEvents(String text);
}