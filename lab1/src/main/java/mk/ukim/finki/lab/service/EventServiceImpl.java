package mk.ukim.finki.lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository events;

    public EventServiceImpl(EventRepository events) {
        this.events = events;
    }

    @Override
    public List<Event> listAll() {
        return events.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return events.searchEvents(text);
    }

}
