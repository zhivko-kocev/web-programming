package mk.ukim.finki.lab.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.Event;

@Repository
public class EventRepository {

    private final List<Event> events;

    public EventRepository() {
        this.events = Arrays.asList(
                new Event("test1", "test1", 1),
                new Event("test2", "test2", 2),
                new Event("test3", "test3", 3),
                new Event("test4", "test4", 4),
                new Event("test5", "test5", 5),
                new Event("test6", "test6", 6),
                new Event("test7", "test7", 7),
                new Event("test8", "test8", 8),
                new Event("test9", "test9", 9),
                new Event("test10", "test10", 10)

        );
    }

    public List<Event> findAll() {
        return events;
    }

    public List<Event> searchEvents(String text) {

        if (text.chars().allMatch(c -> Character.isDigit(c))) {
            return events.stream()
                    .filter(event -> event.getName().contains(text) || event.getDescription().contains(text)
                            || event.getPopularityScore() > Integer.parseInt(text))
                    .toList();
        }

        return events.stream()
                .filter(event -> event.getName().contains(text) || event.getDescription().contains(text))
                .toList();
    }

}
