package mk.ukim.finki.lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mk.ukim.finki.lab.model.Artist;
import mk.ukim.finki.lab.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository performers;

    public ArtistServiceImpl(ArtistRepository performers) {
        this.performers = performers;
    }

    @Override
    public Artist findById(Long id) {
        return performers.findById(id).orElse(null);
    }

    @Override
    public List<Artist> listArtists() {
        return performers.findAll();
    }

}
