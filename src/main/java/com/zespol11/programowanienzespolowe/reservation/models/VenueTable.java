package com.zespol11.programowanienzespolowe.reservation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zespol11.programowanienzespolowe.reservation.models.Reservation;
import com.zespol11.programowanienzespolowe.reservation.models.Venue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "venue_tables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VenueTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cover")
    private int covers;

    @JsonIgnoreProperties({"venueTables"})
    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    @JsonIgnoreProperties({"venueTable"})
    @OneToMany(mappedBy = "venueTable", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    private List<Reservation> reservations;

    public VenueTable(int covers, Venue venue) {
        this.covers = covers;
        this.venue = venue;
    }
}
