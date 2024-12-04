package mk.ukim.finki.lab.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String description;
    private Long capacity;

    @OneToMany(mappedBy = "location")
    private List<Event> events = new ArrayList<>();

    public Location(String name, String address, Long capacity, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.capacity = capacity;
    }
}
