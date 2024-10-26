package mk.ukim.finki.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
    private String name;
    private String description;
    private double popularityScore;
}
