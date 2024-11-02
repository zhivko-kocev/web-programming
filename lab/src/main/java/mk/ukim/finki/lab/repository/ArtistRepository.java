package mk.ukim.finki.lab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.Artist;

@Repository
public class ArtistRepository {

    private final List<Artist> performers;

    public ArtistRepository() {
        this.performers = List.of(
                new Artist(1L, "Test1", "Test1", "Test1"),
                new Artist(2L, "Test2", "Test2", "Test2"),
                new Artist(3L, "Test3", "Test3", "Test3"),
                new Artist(4L, "Test4", "Test4", "Test4"),
                new Artist(5L, "Test5", "Test5", "Test5"));
    }

    public List<Artist> findAll() {
        return performers;
    }

    public Optional<Artist> findById(Long id) {
        return performers.stream().filter(performer -> performer.getId().equals(id)).findAny();
    }

}
