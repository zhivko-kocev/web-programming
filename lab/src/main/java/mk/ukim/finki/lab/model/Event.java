package mk.ukim.finki.lab.model;

import lombok.Data;
import lombok.Generated;

@Data
public class Event {

    private static Long ID_CNT = 0L;

    @Generated
    private Long id;

    private String name;
    private String description;
    private Double popularityScore;
    private Location location;

    public Event(
            String name,
            String description,
            Double popularityScore,
            Location location) {

        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
        this.id = ++ID_CNT;
    }
}
