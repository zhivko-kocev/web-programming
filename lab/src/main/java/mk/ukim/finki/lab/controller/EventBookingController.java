package mk.ukim.finki.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;
import mk.ukim.finki.lab.service.EventBookingService;
import mk.ukim.finki.lab.service.EventService;

@Controller
@RequestMapping("/bookings")
public class EventBookingController {

    private final EventBookingService bookings;
    private final EventService events;

    public EventBookingController(EventBookingService bookings, EventService events) {
        this.bookings = bookings;
        this.events = events;
    }

    @GetMapping
    public String getBookings(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String text,
            HttpServletRequest req,
            Model model) {

        HttpSession session = req.getSession();

        EventBooking booking = (EventBooking) session.getAttribute("booking");

        model.addAttribute(
                "bookings",
                (text == null || text.isEmpty()) ? this.bookings.findAll() : this.bookings.searchBookings(text));

        if (booking == null) {
            return "bookings";

        }

        model.addAttribute("tickets", booking.getNumberOfTickets());
        model.addAttribute("attendee", booking.getAttendeeName());
        model.addAttribute("address", booking.getAttendeeAddress());
        model.addAttribute("event", booking.getEvent().getName());

        return "bookings";
    }

    @PostMapping
    public String setBookings(
            @RequestBody MultiValueMap<String, String> requestBody,
            HttpServletRequest req,
            Model model) {

        HttpSession session = req.getSession();

        if (requestBody.containsKey("canAdd")) {

            EventBooking booking = (EventBooking) session.getAttribute("booking");
            this.bookings.placeBooking(
                    booking.getEvent(),
                    booking.getAttendeeName(),
                    booking.getAttendeeAddress(),
                    booking.getNumberOfTickets());

            session.removeAttribute("booking");

            return "redirect:/events";
        }

        String eventId = requestBody.getFirst("event");
        String ticketsNum = requestBody.getFirst("tickets");
        String ipAddr = req.getLocalAddr();
        String name = requestBody.getFirst("attendee");

        if (ticketsNum == null || ticketsNum.isEmpty() || name == null || name.isEmpty() || eventId == null) {
            return "redirect:/events?error=err";
        }

        Event event = this.events.findById(Long.parseLong(eventId)).get();
        EventBooking booking = new EventBooking(event, name, ipAddr, Long.parseLong(ticketsNum));
        if ((event.getNumCards() - Long.parseLong(ticketsNum)) < 0) {
            return "redirect:/events?error=1";
        }
        event.setNumCards(event.getNumCards() - Long.parseLong(ticketsNum));
        session.setAttribute("booking", booking);

        return "redirect:/bookings";
    }
}
