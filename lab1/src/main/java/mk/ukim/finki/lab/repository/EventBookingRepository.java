package mk.ukim.finki.lab.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.EventBooking;

@Repository
public class EventBookingRepository {

    private final List<EventBooking> bookings;

    public EventBookingRepository() {
        this.bookings = new ArrayList<>();
    }

    public List<EventBooking> findAll() {
        return bookings;
    }

    public EventBooking placeBooking(EventBooking booking) {
        bookings.add(booking);
        return booking;
    }

    public List<EventBooking> searchBookings(String text) {
        return bookings.stream()
                .filter(booking -> booking.getAttendeeName().contains(text) || booking.getEventName().contains(text))
                .toList();
    }
}
