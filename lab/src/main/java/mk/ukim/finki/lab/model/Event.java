package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double popularityScore;

    @ManyToOne
    private Location location;

    private Long numCards;

    public Event(String name, String description, Double popularityScore, Location location, Long numCards) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
        this.numCards = numCards;
    }

}
