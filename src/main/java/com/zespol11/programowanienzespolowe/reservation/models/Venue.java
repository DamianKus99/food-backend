package com.zespol11.programowanienzespolowe.reservation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="venues")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"venue"})
    @OneToMany(mappedBy = "venue", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    private List<VenueTable> venueTables;

    public Venue(String name) {
        this.name = name;
        this.venueTables = new ArrayList<>();
    }

}
