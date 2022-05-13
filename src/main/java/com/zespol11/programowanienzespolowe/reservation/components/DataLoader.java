package com.zespol11.programowanienzespolowe.reservation.components;

import com.zespol11.programowanienzespolowe.reservation.models.Customer;
import com.zespol11.programowanienzespolowe.reservation.models.Reservation;
import com.zespol11.programowanienzespolowe.reservation.models.Venue;
import com.zespol11.programowanienzespolowe.reservation.models.VenueTable;
import com.zespol11.programowanienzespolowe.reservation.repositories.ICustomerRepository;
import com.zespol11.programowanienzespolowe.reservation.repositories.IReservationRepository;
import com.zespol11.programowanienzespolowe.reservation.repositories.IVenueRepository;
import com.zespol11.programowanienzespolowe.reservation.repositories.IVenueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.Month;

@Controller
public class DataLoader implements ApplicationRunner{
    @Autowired
    ICustomerRepository customerRespository;

    @Autowired
    IReservationRepository reservationRepository;

    @Autowired
    IVenueRepository venueRepository;

    @Autowired
    IVenueTableRepository venueTableRepository;

    public DataLoader() {}

    @Override
    public void run(ApplicationArguments args) {

        Venue venue1 = new Venue("The Capybara Cafe");
        Venue venue2 = new Venue("Venue B2");
        Venue venue3 = new Venue("Venue C3");
        Venue venue4 = new Venue("Venue D4");
        Venue venue5 = new Venue("Venue E5");
        Venue venue6 = new Venue("Venue F6");
        Venue venue7 = new Venue("Venue G7");
        Venue venue8 = new Venue("Venue H8");
        Venue venue9 = new Venue("Venue I9");
        Venue venue10 = new Venue("Venue J10");
        Venue venue11 = new Venue("Venue K11");
        Venue venue12 = new Venue("Venue L12");
        Venue venue13 = new Venue("Venue M13");
        Venue venue14 = new Venue("Venue N14");
        Venue venue15 = new Venue("Venue O15");
        Venue venue16 = new Venue("Venue P16");
        Venue venue17 = new Venue("Venue Q17");
        Venue venue18 = new Venue("Venue R18");
        Venue venue19 = new Venue("Venue S19");
        Venue venue20 = new Venue("Venue T20");
        venueRepository.save(venue1);
        venueRepository.save(venue2);
        venueRepository.save(venue3);
        venueRepository.save(venue4);
        venueRepository.save(venue5);
        venueRepository.save(venue6);
        venueRepository.save(venue7);
        venueRepository.save(venue8);
        venueRepository.save(venue9);
        venueRepository.save(venue10);
        venueRepository.save(venue11);
        venueRepository.save(venue12);
        venueRepository.save(venue13);
        venueRepository.save(venue14);
        venueRepository.save(venue15);
        venueRepository.save(venue16);
        venueRepository.save(venue17);
        venueRepository.save(venue18);
        venueRepository.save(venue19);
        venueRepository.save(venue20);

        VenueTable venueTable1 = new VenueTable(10, venue1);
        VenueTable venueTable2 = new VenueTable(9, venue1);
        VenueTable venueTable3 = new VenueTable(8, venue1);
        VenueTable venueTable4 = new VenueTable(10, venue1);
        VenueTable venueTable5 = new VenueTable(9, venue1);
        VenueTable venueTable6 = new VenueTable(8, venue1);
        VenueTable venueTable7 = new VenueTable(10, venue1);
        VenueTable venueTable8 = new VenueTable(9, venue1);
        VenueTable venueTable9 = new VenueTable(8, venue1);
        VenueTable venueTable10 = new VenueTable(10, venue1);
        VenueTable venueTable11 = new VenueTable(9, venue1);
        VenueTable venueTable12 = new VenueTable(8, venue1);
        VenueTable venueTable13 = new VenueTable(1, venue1);
        VenueTable venueTable14 = new VenueTable(2, venue1);
        VenueTable venueTable15 = new VenueTable(3, venue1);
        VenueTable venueTable16 = new VenueTable(4, venue1);
        VenueTable venueTable17 = new VenueTable(1, venue1);
        VenueTable venueTable18 = new VenueTable(2, venue1);
        VenueTable venueTable19 = new VenueTable(3, venue1);
        VenueTable venueTable20 = new VenueTable(4, venue1);

        venueTableRepository.save(venueTable1);
        venueTableRepository.save(venueTable2);
        venueTableRepository.save(venueTable3);
        venueTableRepository.save(venueTable4);
        venueTableRepository.save(venueTable5);
        venueTableRepository.save(venueTable6);
        venueTableRepository.save(venueTable7);
        venueTableRepository.save(venueTable8);
        venueTableRepository.save(venueTable9);
        venueTableRepository.save(venueTable10);
        venueTableRepository.save(venueTable11);
        venueTableRepository.save(venueTable12);
        venueTableRepository.save(venueTable13);
        venueTableRepository.save(venueTable14);
        venueTableRepository.save(venueTable15);
        venueTableRepository.save(venueTable16);
        venueTableRepository.save(venueTable17);
        venueTableRepository.save(venueTable18);
        venueTableRepository.save(venueTable19);
        venueTableRepository.save(venueTable20);
        venueTableRepository.save(venueTable1);
        venueTableRepository.save(venueTable2);
        venueTableRepository.save(venueTable3);
        venueTableRepository.save(venueTable4);
        venueTableRepository.save(venueTable5);
        venueTableRepository.save(venueTable6);
        venueTableRepository.save(venueTable7);
        venueTableRepository.save(venueTable8);
        venueTableRepository.save(venueTable9);
        venueTableRepository.save(venueTable10);


    }
}
