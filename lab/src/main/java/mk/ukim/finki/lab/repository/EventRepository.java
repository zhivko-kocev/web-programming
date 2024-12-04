package mk.ukim.finki.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // private final List<Event> events;

    // public EventRepository() {
    // this.events = new ArrayList<>();
    // }

    // public List<Event> findAll() {
    // return this.events;
    // }

    // public Optional<Event> findById(Long id) {
    // return this.events
    // .stream()
    // .filter(event -> event.getId().equals(id))
    // .findAny();
    // }

    // public Event createEvent(Event event) {

    // if (this.events.stream().anyMatch(e -> e.getId().equals(event.getId()))) {
    // return event;
    // }

    // this.events.add(event);
    // return event;
    // }

    // public Event updateEvent(Long id, String name, String description, Double
    // popularityScore, Location location,
    // Long numCards) {

    // Event toUpdate = this.events
    // .stream()
    // .filter(e -> e.getId().equals(id))
    // .findAny()
    // .orElse(null);

    // if (toUpdate != null) {
    // toUpdate.setName(name);
    // toUpdate.setDescription(description);
    // toUpdate.setLocation(location);
    // toUpdate.setPopularityScore(popularityScore);
    // toUpdate.setNumCards(numCards);
    // }

    // return toUpdate;
    // }

    // public boolean removeEvent(Long id) {

    // Optional<Event> toDelete = this.events
    // .stream()
    // .filter(event -> event.getId().equals(id))
    // .findAny();

    // return toDelete.isPresent() ? this.events.remove(toDelete.get()) : false;
    // }

    // public List<Event> searchEvents(String text) {

    // if (text.chars().allMatch(c -> Character.isDigit(c))) {
    // return this.events
    // .stream()
    // .filter(event -> event.getName().contains(text) ||
    // event.getDescription().contains(text) ||
    // event.getPopularityScore() > Integer.parseInt(text))
    // .toList();
    // }

    // return this.events
    // .stream()
    // .filter(event -> event.getName().contains(text) ||
    // event.getDescription().contains(text))
    // .toList();
    // }
}
