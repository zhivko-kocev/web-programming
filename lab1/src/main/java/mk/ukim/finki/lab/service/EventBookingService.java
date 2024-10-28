package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.EventBooking;
import java.util.*;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);

    List<EventBooking> listAll();

    List<EventBooking> searchBookings(String text);
}
