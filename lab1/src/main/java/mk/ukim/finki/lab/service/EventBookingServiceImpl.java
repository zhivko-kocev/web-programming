package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.EventBooking;

public class EventBookingServiceImpl implements EventBookingService {

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress,
            int numberOfTickets) {
        return new EventBooking(eventName, attendeeName, attendeeAddress, Integer.toUnsignedLong(numberOfTickets));
    }

}
