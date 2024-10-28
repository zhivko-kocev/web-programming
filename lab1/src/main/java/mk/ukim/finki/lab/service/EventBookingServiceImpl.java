package mk.ukim.finki.lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mk.ukim.finki.lab.model.EventBooking;
import mk.ukim.finki.lab.repository.EventBookingRepository;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private final EventBookingRepository bookings;

    public EventBookingServiceImpl(EventBookingRepository bookings) {
        this.bookings = bookings;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress,
            int numberOfTickets) {
        return bookings.placeBooking(
                new EventBooking(eventName, attendeeName, attendeeAddress, Integer.toUnsignedLong(numberOfTickets)));
    }

    @Override
    public List<EventBooking> listAll() {
        return bookings.findAll();
    }

    @Override
    public List<EventBooking> searchBookings(String text) {
        return bookings.searchBookings(text);
    }

}
