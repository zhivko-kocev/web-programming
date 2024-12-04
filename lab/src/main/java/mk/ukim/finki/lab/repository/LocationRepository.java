package mk.ukim.finki.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
