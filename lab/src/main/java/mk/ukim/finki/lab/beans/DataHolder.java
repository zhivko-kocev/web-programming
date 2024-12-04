package mk.ukim.finki.lab.beans;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.repository.EventRepository;
import mk.ukim.finki.lab.repository.LocationRepository;

@Component
class DataHolder {

        private final EventRepository eventsR;
        private final LocationRepository locationsR;

        public DataHolder(EventRepository eventsR, LocationRepository locationsR) {
                this.eventsR = eventsR;
                this.locationsR = locationsR;
        }

        @PostConstruct
        public void init() {
                this.locationsR.saveAll(List.of(
                                new Location("Kavadarci", "Leninova 13", 50L,
                                                "Vintage house that a big intellectual was born!"),
                                new Location("Skopje", "Slavejko Arsov 144", 150L, "Big complex with many activities"),
                                new Location("Skopje", "Rugjer Boshkovikj 16", 20L, "Laboratory at FCSE!"),
                                new Location("Kavadarci", "Disanska", 300L,
                                                "Big elegant restaurant located in the park!"),
                                new Location("Kavadarci", "Mito Hadzi Vasilev-Jasmin 24", 200L,
                                                "Vintage bar that intelectuals and inovators go!")));

                this.eventsR.saveAll(List.of(
                                new Event("Graduation Party", "The best grad party ever!", 7.0,
                                                this.locationsR.findById(1L).get(), 200L),
                                new Event("Music Festival", "An unforgettable night of music and fun!", 10.0,
                                                this.locationsR.findById(2L).get(), 200L),
                                new Event("Food Tasting", "Explore exotic flavors from around the world!", 5.0,
                                                this.locationsR.findById(3L).get(), 200L),
                                new Event("Tech Conference", "Insights from the world ofinnovation.", 8.5,
                                                this.locationsR.findById(4L).get(), 200L),
                                new Event("Art Exhibit", "A journey through modern art.", 8.0,
                                                this.locationsR.findById(5L).get(), 200L),
                                new Event("Charity Gala", "Join us for a night of giving back.", 9.2,
                                                this.locationsR.findById(2L).get(), 200L),
                                new Event("Beach Clean-up", "Make a difference for our environment.", 3.0,
                                                this.locationsR.findById(1L).get(), 200L),
                                new Event("Comedy Night", "Laugh out loud with top comedians.", 7.0,
                                                this.locationsR.findById(4L).get(), 200L),
                                new Event("Book Launch", "Celebrating a new release by a topauthor.", 6.0,
                                                this.locationsR.findById(3L).get(), 200L),
                                new Event("Yoga Retreat", "Find peace and relaxation.", 9.0,
                                                this.locationsR.findById(5L).get(), 200L)));

        }
}