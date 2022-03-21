package com.zespol11.programowanienzespolowe.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import com.zespol11.programowanienzespolowe.userRegistration.appuser.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime date;

    @ManyToOne
    private Desk desk;

}
