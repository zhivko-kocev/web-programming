package mk.ukim.finki.lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.model.Song;
import mk.ukim.finki.lab.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songs;

    public SongServiceImpl(SongRepository songs) {
        this.songs = songs;
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songs.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songs.findByTrackId(trackId);
    }

    @Override
    public List<Song> listSongs() {
        return songs.findAll();
    }

}
