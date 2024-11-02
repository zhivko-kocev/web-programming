package mk.ukim.finki.lab.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Song {
    private String trackId;
    private String title;
    private String genre;
    private Integer releaseYear;
    private List<Artist> performers;

    public void addArtist(Artist artist) {

        if (performers.stream().anyMatch(performer -> performer.getId().equals(artist.getId()))) {
            return;
        }

        performers.add(artist);
    }
}
