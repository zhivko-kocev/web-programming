package mk.ukim.finki.lab.model;

import lombok.Data;
import lombok.Generated;

@Data
public class EventBooking {

    private static Long ID_CNT = 0L;

    @Generated
    private Long id;

    private Event event;
    private String attendeeName;
    private String attendeeAddress;
    private Long numberOfTickets;

    public EventBooking(
            Event event,
            String attendeeName,
            String attendeeAddress,
            Long numberOfTickets) {

        this.event = event;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
        this.id = ++ID_CNT;
    }
}
