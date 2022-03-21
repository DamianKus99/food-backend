package com.zespol11.programowanienzespolowe.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void addReservation(@RequestBody @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") Reservation reservation){
        reservationService.addReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.getAll();
    }

    @GetMapping(path = "/reservation/{id}")
    public Reservation getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }

    @GetMapping(path = "/dates/{date}")
    public List<Reservation> getReservationByDate(@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date){
        return reservationService.getReservationByDate(date);
    }

    @GetMapping(path = "/{number}")
    public List<Reservation> getReservationByDesk(@PathVariable Integer number){
        return reservationService.getReservationByDesk(number);
    }

    @GetMapping(path = "/desk/{number}")
    public List<Reservation> getReservationByDeskAndDate(@PathVariable Integer number,
                                                         @RequestParam
                                                         @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date){
        return reservationService.getReservationByDeskAndDate(number, date);
    }

    @PutMapping(path = "/{id}")
    public void updateReservation(@PathVariable Long id,
                                  @RequestParam(required = false) String surname,
                                  @RequestParam(required = false) @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") LocalDateTime dateTime,
                                  @RequestParam(required = false) Integer deskNumber){
        reservationService.updateReservation(id, surname, dateTime, deskNumber);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }

}
