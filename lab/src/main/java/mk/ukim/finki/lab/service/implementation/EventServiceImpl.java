package mk.ukim.finki.lab.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.repository.EventRepository;
import mk.ukim.finki.lab.service.EventService;
import mk.ukim.finki.lab.service.LocationService;

@Service
public class EventServiceImpl implements EventService {

        private final EventRepository events;
        private final LocationService locations;

        public EventServiceImpl(EventRepository events, LocationService locations) {
                this.events = events;
                this.locations = locations;

                this.events.createEvent(
                                new Event("Graduation Party", "The best grad party ever!", 7.0,
                                                this.locations.findById(1L).get()));

                this.events.createEvent(new Event("Music Festival", "An unforgettable night of music and fun!", 10.0,
                                this.locations.findById(2L).get()));

                this.events.createEvent(new Event("Food Tasting", "Explore exotic flavors from around the world!", 5.0,
                                this.locations.findById(3L).get()));

                this.events.createEvent(new Event("Tech Conference", "Insights from the world of innovation.", 8.5,
                                this.locations.findById(4L).get()));

                this.events.createEvent(
                                new Event("Art Exhibit", "A journey through modern art.", 8.0,
                                                this.locations.findById(5L).get()));

                this.events.createEvent(
                                new Event("Charity Gala", "Join us for a night of giving back.", 9.2,
                                                this.locations.findById(2L).get()));

                this.events.createEvent(
                                new Event("Beach Clean-up", "Make a difference for our environment.", 3.0,
                                                this.locations.findById(1L).get()));

                this.events.createEvent(
                                new Event("Comedy Night", "Laugh out loud with top comedians.", 7.0,
                                                this.locations.findById(4L).get()));

                this.events.createEvent(new Event("Book Launch", "Celebrating a new release by a top author.", 6.0,
                                this.locations.findById(3L).get()));

                this.events
                                .createEvent(
                                                new Event("Yoga Retreat", "Find peace and relaxation.", 9.0,
                                                                this.locations.findById(5L).get()));

        }

        @Override
        public Event createEvent(String name, String description, Double popularityScore, Location location) {
                return this.events.createEvent(new Event(name, description, popularityScore, location));
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
                return this.events.removeEvent(id);
        }

        @Override
        public List<Event> searchEvents(String text) {
                return this.events.searchEvents(text);
        }

        @Override
        public Event updateEvent(Long id, String name, String description, Double popularityScore, Location location) {
                return this.events.updateEvent(
                                id, name, description, popularityScore, location);
        }

}
