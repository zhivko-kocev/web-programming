package mk.ukim.finki.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.lab.model.EventBooking;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking, Long> {

}
