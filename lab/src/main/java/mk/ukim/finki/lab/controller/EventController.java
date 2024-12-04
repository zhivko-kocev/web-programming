package mk.ukim.finki.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.service.EventService;
import mk.ukim.finki.lab.service.LocationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService events;
    private final LocationService locations;

    public EventController(EventService events, LocationService locations) {
        this.events = events;
        this.locations = locations;
    }

    @GetMapping
    public String getEvents(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String text,
            Model model) {

        model.addAttribute("events",
                (text == null || text.isEmpty()) ? this.events.findAll() : this.events.searchEvents(text));

        model.addAttribute("error", error != null ? true : false);

        return "events";
    }

    @GetMapping("/add")
    public String getAddEvent(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("locations", this.locations.findAll());
        return "add-event";
    }

    @PostMapping("/add")
    public String saveEvent(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double popularityScore,
            @RequestParam Long locationId,
            @RequestParam Long numCards,
            @RequestParam Boolean update,
            @RequestParam(required = false) Long id) {

        if (name.isEmpty() || description.isEmpty() || popularityScore == null || locationId == null) {
            return "redirect:/events/add?error=1";
        }

        Location location = this.locations.findById(locationId).get();

        if (update) {
            this.events.updateEvent(id, name, description, popularityScore, location,
                    numCards);
            return "redirect:/events";
        }

        this.events.createEvent(name, description, popularityScore, location, numCards);

        return "redirect:/events";
    }

    @PostMapping("/edit/{id}")
    public String updateEvent(
            @PathVariable Long id, Model model) {

        Event event = this.events.findById(id).get();
        model.addAttribute("event", event);
        model.addAttribute("locations", this.locations.findAll());
        model.addAttribute("update", "has");

        return "add-event";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(
            @PathVariable Long id) {
        this.events.removeEvent(id);
        return "redirect:/events";
    }

}
