package mk.ukim.finki.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    // private final List<Location> locations;

    // public LocationRepository() {
    // this.locations = List.of(
    // new Location("Kavadarci", "Leninova 13", 50L, "Vintage house that a big
    // intellectual was born!"),
    // new Location("Skopje", "Slavejko Arsov 144", 150L, "Big complex with many
    // activities"),
    // new Location("Skopje", "Rugjer Boshkovikj 16", 20L, "Laboratory at FCSE!"),
    // new Location("Kavadarci", "Disanska", 300L, "Big elegant restaurant located
    // in the park!"),
    // new Location("Kavadarci", "Mito Hadzi Vasilev-Jasmin 24", 200L,
    // "Vintage bar that intelectuals and inovators go!"));
    // }

    // public List<Location> findAll() {
    // return this.locations;
    // }

    // public Optional<Location> findById(Long id) {
    // return this.locations
    // .stream()
    // .filter(location -> location.getId().equals(id))
    // .findAny();
    // }
}
