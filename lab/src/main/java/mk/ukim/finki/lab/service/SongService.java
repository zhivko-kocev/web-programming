package mk.ukim.finki.lab.service;

import java.util.List;

import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.model.Song;

public interface SongService {
    List<Song> listSongs();

    Artist addArtistToSong(Artist artist, Song song);

    public Song findByTrackId(String trackId);
}