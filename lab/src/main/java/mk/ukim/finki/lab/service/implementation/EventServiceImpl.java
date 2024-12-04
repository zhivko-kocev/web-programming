package mk.ukim.finki.lab.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.repository.EventRepository;
import mk.ukim.finki.lab.service.EventService;

@Service
public class EventServiceImpl implements EventService {

        private final EventRepository events;

        public EventServiceImpl(EventRepository events) {
                this.events = events;

        }

        @Override
        public Event createEvent(String name, String description, Double popularityScore, Location location,
                        Long numCards) {
                return this.events.save(new Event(name, description, popularityScore, location, numCards));
        }

        @Override
        public List<Event> findAll() {
                return this.events.findAll();
        }

        @Override
        public Optional<Event> findById(Long id) {
                return this.events.findById(id);
        }

        @Override
        public boolean removeEvent(Long id) {
                this.events.deleteById(id);
                return true;
        }

        @Override
        public List<Event> searchEvents(String text) {
                return this.events.findAll().stream().filter(event -> event.getName().contains(text)).toList();
        }

        @Override
        public Event updateEvent(Long id, String name, String description, Double popularityScore, Location location,
                        Long numCards) {
                Event event = this.events.findById(id).get();

                if (event != null) {
                        event.setName(name);
                        event.setDescription(description);
                        event.setPopularityScore(popularityScore);
                        event.setLocation(location);
                        event.setNumCards(numCards);

                        this.events.save(event);
                }
                return event;
        }

}
