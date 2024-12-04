package mk.ukim.finki.lab.service;

import java.util.List;
import java.util.Optional;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;

public interface EventBookingService {

    List<EventBooking> findAll();

    Optional<EventBooking> findById(Long id);

    EventBooking placeBooking(Event event, String attendeeName, String attendeeAddress, Long numberOfTickets);

    boolean removeBooking(Long id);

    List<EventBooking> searchBookings(String text);
}
