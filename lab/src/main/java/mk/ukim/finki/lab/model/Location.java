package mk.ukim.finki.lab.model;

import lombok.Data;
import lombok.Generated;

@Data
public class Location {

    private static Long ID_CNT = 0L;

    @Generated
    private Long id;

    private String name;
    private String address;
    private String description;
    private Long capacity;

    public Location(
            String name,
            String address,
            Long capacity,
            String description) {

        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
        this.id = ++ID_CNT;
    }
}
