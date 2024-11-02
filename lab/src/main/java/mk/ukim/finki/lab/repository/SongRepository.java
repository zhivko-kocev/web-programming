package mk.ukim.finki.lab.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.model.Song;

@Repository
public class SongRepository {
    private List<Song> songs;

    public SongRepository() {
        this.songs = List.of(
                new Song("Test1", "Test1", "Test1", 2024, new ArrayList<>()),
                new Song("Test2", "Test2", "Test2", 2024, new ArrayList<>()),
                new Song("Test3", "Test3", "Test3", 2024, new ArrayList<>()),
                new Song("Test4", "Test4", "Test4", 2024, new ArrayList<>()),
                new Song("Test5", "Test5", "Test5", 2024, new ArrayList<>()));
    }

    public List<Song> findAll() {
        return songs;
    }

    public Song findByTrackId(String trackId) {
        return songs.stream().filter(song -> song.getTrackId().equals(trackId)).findAny().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song) {

        Song s = songs.stream().filter(obj -> obj.getTrackId().equals(song.getTrackId())).findAny().orElse(null);

        if (s == null) {
            return artist;
        }

        s.addArtist(artist);

        return artist;
    }
}
