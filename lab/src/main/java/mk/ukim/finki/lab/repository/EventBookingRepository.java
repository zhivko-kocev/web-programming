package mk.ukim.finki.lab.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.EventBooking;

@Repository
public class EventBookingRepository {

    private final List<EventBooking> bookings;

    public EventBookingRepository() {
        this.bookings = new ArrayList<>();
    }

    public List<EventBooking> findAll() {
        return this.bookings;
    }

    public Optional<EventBooking> findById(Long id) {
        return this.bookings
                .stream()
                .filter(booking -> booking.getId().equals(id))
                .findAny();
    }

    public EventBooking placeBooking(EventBooking booking) {

        this.bookings.add(booking);
        return booking;
    }

    public boolean removeBooking(Long id) {
        Optional<EventBooking> toDelete = this.bookings
                .stream()
                .filter(booking -> booking.getId().equals(id))
                .findAny();

        return toDelete.isPresent() ? this.bookings.remove(toDelete.get()) : false;
    }

    public List<EventBooking> searchBookings(String text) {
        return this.bookings
                .stream()
                .filter(booking -> booking.getAttendeeName().contains(text)
                        || booking.getEvent().getName().contains(text))
                .toList();
    }

}
