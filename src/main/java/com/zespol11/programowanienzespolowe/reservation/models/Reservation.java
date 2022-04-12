package com.zespol11.programowanienzespolowe.reservation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="reservations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"reservations"})
    @ManyToOne
    @JoinColumn(name = "r_customer_id", nullable = false)
    private Customer customer;

    @JsonIgnoreProperties({"reservations"})
    @ManyToOne
    @JoinColumn(name = "venue_table_id", nullable = false)
    private VenueTable venueTable;

    @Column(name = "r_start")
    private LocalDateTime start;

    @Column(name = "r_end")
    private LocalDateTime end;

    @Column(name = "r_partySize")
    private int partySize;

    @Column(name = "r_reservationNotes")
    private String reservationNotes;

    public Reservation(Customer customer, VenueTable venueTable, LocalDateTime start, LocalDateTime end, int partySize, String reservationNotes) {
        this.customer = customer;
        this.venueTable = venueTable;
        this.start = start;
        this.end = end;
        this.partySize = partySize;
        this.reservationNotes = reservationNotes;
    }
}
