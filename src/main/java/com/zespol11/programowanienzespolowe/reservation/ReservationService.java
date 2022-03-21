package com.zespol11.programowanienzespolowe.reservation;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final DeskRepository deskRepository;

    public ReservationService(ReservationRepository reservationRepository, DeskRepository deskRepository) {
        this.reservationRepository = reservationRepository;
        this.deskRepository = deskRepository;
    }

    @Transactional
    public void addReservation(Reservation reservation){

        Desk desk = deskRepository.findById(reservation.getDesk().getNumber())
                .orElseThrow(() -> new IllegalStateException("Desk must not be null!"));

        if(reservation.getDate() == null){
            throw new IllegalStateException("Date must not be null!");
        }

        if(!desk.getAvailable().contains(reservation.getDate())){
            throw new IllegalStateException("Desk number " + desk.getNumber()
                    + " is not available on " + reservation.getDate());
        }

        desk.getAvailable().remove(reservation.getDate());

        reservationRepository.save(reservation);
        deskRepository.save(desk);



    }

    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

    public Reservation getReservationById(Long id){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Reservation with id " +
                        id + "does not exist"));

        return reservation;
    }

    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    @Transactional
    public void updateReservation(Long id, String surname, LocalDateTime dateTime, Integer deskNumber){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Reservation with id " +
                        id + "does not exist"));


        if(surname != null &&
                surname.length() > 0 &&
                !Objects.equals(reservation.getSurname(), surname)){
            reservation.setSurname(surname);
        }


        Optional<Desk> desk = deskRepository.findById(deskNumber);

        if(desk.isPresent()
                        && dateTime != null
                        && desk.get().getAvailable().contains(dateTime)){

            Desk desk1 = desk.get();

            desk1.getAvailable().remove(dateTime);
            reservation.getDesk().getAvailable().add(reservation.getDate());
            reservation.setDesk(desk1);
            reservation.setDate(dateTime);

        } else if(!Objects.equals(deskNumber, reservation.getDesk().getNumber())
                && desk.isPresent()
                && desk.get().getAvailable().contains(reservation.getDate())) {
            Desk desk1 = desk.get();

            reservation.getDesk().getAvailable().add(reservation.getDate());
            reservation.setDesk(desk1);
            desk1.getAvailable().remove(reservation.getDate());

        } else if(dateTime != null
                && !Objects.equals(reservation.getDate(), dateTime)
                && reservation.getDesk().getAvailable().contains(dateTime)
        ){
            reservation.getDesk().getAvailable().add(reservation.getDate());

            reservation.getDesk().getAvailable().remove(dateTime);

            reservation.setDate(dateTime);
        }



    }

    public List<Reservation> getReservationByDate(LocalDate date) {
        return reservationRepository.findAllByDate(date);
    }

    public List<Reservation> getReservationByDesk(Integer number) {
        return reservationRepository.getReservationByDesk(number);
    }

    public List<Reservation> getReservationByDeskAndDate(Integer number, LocalDate date) {

        LocalDateTime start = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(date, LocalTime.MAX);

        return reservationRepository.getReservationByDateAndDesk(number, start, end);
    }


}
