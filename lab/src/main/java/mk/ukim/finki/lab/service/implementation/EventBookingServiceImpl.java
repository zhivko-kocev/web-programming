package mk.ukim.finki.lab.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;
import mk.ukim.finki.lab.repository.EventBookingRepository;
import mk.ukim.finki.lab.service.EventBookingService;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private final EventBookingRepository bookings;

    public EventBookingServiceImpl(EventBookingRepository bookings) {
        this.bookings = bookings;
    }

    @Override
    public List<EventBooking> findAll() {
        return this.bookings.findAll();
    }

    @Override
    public Optional<EventBooking> findById(Long id) {
        return this.bookings.findById(id);
    }

    @Override
    public EventBooking placeBooking(Event event, String attendeeName, String attendeeAddress,
            Long numberOfTickets) {

        return this.bookings.save(
                new EventBooking(event, attendeeName, attendeeAddress, numberOfTickets));
    }

    @Override
    public boolean removeBooking(Long id) {
        this.bookings.deleteById(id);
        return true;
    }

    // @Override
    // public List<EventBooking> searchBookings(String text) {
    // return this.bookings.findAll(text);
    // }

}
