package com.zespol11.programowanienzespolowe.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Desk {

    @Id
    @NotNull
    private Integer number;

    private Integer capacity;

    private String location;

    @ElementCollection
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private Set<LocalDateTime> available = new TreeSet<>();



}
