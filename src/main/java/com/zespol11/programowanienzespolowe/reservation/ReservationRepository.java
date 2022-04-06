package com.zespol11.programowanienzespolowe.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query(value = "SELECT * FROM Reservation r WHERE DATE(r.date) = ?1", nativeQuery = true)
    List<Reservation> findAllByDate(LocalDate date);

    @Query("SELECT r FROM Reservation r WHERE r.desk.number = ?1")
    List<Reservation> getReservationByDesk(Integer number);

    @Query("SELECT r FROM Reservation r WHERE r.date between ?2 and ?3 and r.desk.number = ?1")
    List<Reservation> getReservationByDateAndDesk(Integer number, LocalDateTime start, LocalDateTime end);

}
